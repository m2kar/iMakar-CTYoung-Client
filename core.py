# -*- coding: utf-8 -*- 
"""

"""
#   @Time:  2017/8/30 9:03
#   @Author:still_night@163.com
#   @File:  core.py
from __future__ import unicode_literals
from Crypto.Cipher import AES
import requests
import re
import log

key = b"\x51\xDB\x25\x26\x10\xB6\x42\x01\x28\xDE\x86\xCC\x05\x4B\xC0\xC8"
exkey = b"\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00"
AESTool = AES.new(key, AES.MODE_CBC, exkey)


class NetworkError(Exception):
    pass


class LoginError(Exception):
    pass


def encrypt(str_old):
    if not isinstance(str_old, (str,)):
        raise TypeError("function encrypt only receive str ,but str_old = {}".format(str_old))
    str_old = str_old + (16 - len(str_old) % 16) * b"\x0A"
    ciphertext = AESTool.encrypt(str_old)
    arr = ["%02X" % ord(c) for c in ciphertext]
    hextext = "".join(arr)
    return hextext


class User:
    def __init__(self, username, password):
        log.debug("User.__init__ :{} {}".format(username, password))
        if not isinstance(username, str):
            raise TypeError("username must be str")
        username = username.strip()
        if not username:
            raise ValueError("username can't be blank")
        self.username = username
        if not isinstance(password, str):
            raise TypeError("password must be str")
        password = password.strip()
        if not password:
            raise ValueError("password can't be blank")
        self.password = password
        self.encrypt_password()

    def __str__(self):
        return "<{}.{} username={} password={}>".format(__name__,self.__class__.__name__,self.username,self.password)

    __repr__=__str__

    def encrypt_password(self):
        self.en_password = encrypt(self.password)
        log.debug("encrypt_password {} --> {} ".format(self.password, self.en_password))


class SinglenetSession(requests.Session):
    def __init__(self, userip=None, user=None, uuid=None):
        super(SinglenetSession, self).__init__()
        log.info("singlenetSession init :userip:{0} user:{1} uuid:{2}".format(userip,user,uuid))
        if user and not isinstance(user, User):
            raise TypeError("TypeError: SinglenetSession.user must be class User")
        self.user = user
        if userip and not isinstance(userip, str):
            raise TypeError("TypeError: SinglenetSession.ip must be str")
        elif self.illeagl_ip(userip):
            log.error("illegal_ip :{}".format(userip))
            raise ValueError("ValueError: Wrong ip {}".format(userip))
        self.userip = userip
        if uuid and not isinstance(uuid, str):
            raise TypeError("uuid type error: {}".format(uuid))
        self.uuid = uuid
        self.host = "219.148.205.34:8090"
        self.headers.update({"User-Agent": "China Telecom Client", "Content-Type": "application/x-www-form-urlencoded"})
        log.debug("init sucess {}".format(self))

    def __str__(self):
        return "<{0} userip=\"{1}\" user={2} uuid=\"{3}\">".format(self.__class__.__name__,self.userip,self.user,self.uuid)

    __repr__=__str__

    def login(self):
        log.debug("login ")
        if not (self.user and self.userip):
            raise ValueError("not find user or userip")
        self.request_uuid()
        self.request_login()
        if self.login_response_code != '200':
            return False
        else:
            return True

    def logout(self):
        if not (self.uuid and self.userip):
            raise ValueError("not find uuid or userip")
        self.request_logout()
        if self.logout_response_code != '150':
            return False
        else:
            return True

    def post(self, url, **kwargs):
        log.debug("Post {} {}".format(url,kwargs))
        try:
            response = super(SinglenetSession, self).post(url, **kwargs)
        except (requests.ConnectionError, requests.ConnectTimeout) as e:
            raise NetworkError("{}".format(e))
        if not response.status_code == 200:
            raise NetworkError
        return response

    def request_uuid(self):
        response = self.post("http://{0}/showlogin.do".format(self.host), data={"wlanuserip": self.userip})
        result = re.search(r"<Uuid>(\w+?)</Uuid>", response.content)
        if not result:
            raise LoginError("获取uuid失败")
        self.uuid = result.group(1)
        log.info("get uuid {}".format(self))

    def request_login(self):
        data_dict = {"uuid": self.uuid,
                     "userip": self.userip,
                     "username": self.user.username,
                     "password": self.user.en_password}
        data = "uuid={uuid}&userip={userip}&username={username}&password={password}".format(**data_dict)
        response = self.post("http://{0}/servlets/G3loginServlet".format(self.host), data=data)
        result = re.search(r'<ResponseCode>(\d+?)</ResponseCode>', response.content)
        if not result:
            raise LoginError("登陆失败,无返回值")
        self.login_response_code = result.group(1)
        log.info("{}.request_login  ; {}".format(self,result))
        return True

    def request_logout(self):
        data = {"uuid": self.uuid,
                "userip": self.userip}
        response = self.post("http://{0}/servlets/G3logoutServlet".format(self.host), data=data)
        result = re.search(r'<ResponseCode>(\d+?)</ResponseCode>', response.content)
        if not result:
            raise LoginError("登陆失败,无返回值")
        self.logout_response_code = result.group(1)
        log.info("{}.request_logout  ; {}".format(self, result))
        return True

    @staticmethod
    def get_code_msg(code):
        msg_dict = {"71": u"账号密码错误",
                    "72": u"账号状态错误",
                    "73": u"非法ip",
                    "74": u"ip不在范围内",
                    "150": u"注销成功",
                    "200": u"登陆成功",
                    "255": u"未知原因注销失败"}
        return msg_dict.get(str(code), u"未知错误:代码{}".format(code))

    @staticmethod
    def illeagl_ip(ip):
        result = re.match(r'(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})', ip)
        if result:
            for each in result.groups():
                if not 255 >= int(each) >= 0:
                    return True
            else:
                return False
        else:
            return True
