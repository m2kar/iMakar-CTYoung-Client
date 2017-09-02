# -*- coding: utf-8 -*- 
"""
设置个人配置文件
使用from config import config 来使用
"""
#   @Time:  2017/8/30 21:24
#   @Author:still_night@163.com
#   @File:  config.py

from __future__ import unicode_literals
import json
import os
import datetime
import time
import const
import log


# cf=ConfigParser()

# cf.read(filename)
# secs=cf.sections()

# ConfigParser.ConfigParser()
class SinglenetConfig():
    """
    User:
        username
        password
    Sessions:
        userip
        uuid
        username
        t

    """

    def __init__(self, json_file=const.DATAFILE):
        log.debug("init Config")
        self.json_file = json_file
        self.conf_dict = {"Users": {"username":"","password":""}, "Sessions": []}
        self.read()
        self.write()

    def __del__(self):
        log.debug("del Config")
        self.write()


    def read(self, json_file=None):
        """读取配置文件,并入内存中配置文件,如果出错则返回空"""
        json_file = json_file or self.json_file
        if not os.path.exists(json_file):
            log.debug("config.read(): {} not exist".format(json_file))
            return {}
        with open(json_file) as fp:
            try:
                conf_dict = json.load(fp)
            except Exception as e:
                # os.remove(json_file)
                return {}
            else:
                self.update(conf_dict)
                return conf_dict

    def update(self, adict):
        """使用dict来更新配置文件"""
        self.conf_dict["Users"].update(adict.get("Users", {}))
        for new in adict.get("Sessions", []):
            for old in self.conf_dict["Sessions"]:
                if cmp(new, old) == 0:
                    break
            else:
                self.conf_dict["Sessions"].append(new)
        self.write()

    def write(self, filename=None):
        """重新写入配置文件"""
        filename = filename or self.json_file
        with open(filename, str("w+")) as fp:
            json.dump(self.conf_dict, fp, indent=4)

    def set_user(self, username=None, password=None):
        if username:
            self.conf_dict["Users"]["username"] = username
        if password:
            self.conf_dict["Users"]["password"] = password
        self.write()
        self.write()

    @property
    def username(self):
        return self.conf_dict["Users"]['username']

    @username.setter
    def username(self, value):
        self.conf_dict["Users"]['username'] = value
        self.write()

    @property
    def password(self):
        return self.conf_dict["Users"]['password']

    @password.setter
    def password(self, value):
        self.conf_dict['password'] = value
        self.write()

    def add_session(self, userip, uuid, username=None, t=time.time()):
        """添加一个登录记录"""
        self.conf_dict["Sessions"].append({"userip": userip, "uuid": uuid, "username": username, "t": t})
        self.write()

    def remove_session(self, userip, uuid):
        """删除一个登陆记录"""
        for i, session in enumerate(self.conf_dict["Sessions"]):
            if userip == session['userip'] and uuid == session['uuid']:
                self.conf_dict["Sessions"].pop(i)
        self.write()

    def remove_session_by_index(self, index):
        """删除指定索引index的记录"""
        self.conf_dict["Sessions"].pop(index)
        self.write()

    @property
    def sessions(self):
        """设定属性值 session为列表,并将时间戳t转化为dt"""
        result=self.conf_dict['Sessions']
        for each in result:
            t=each.get("t", 0.0)
            try:
                dt=datetime.datetime.fromtimestamp(t)
            except (TypeError,ValueError):
                dt=datetime.datetime.fromtimestamp(0.0)
            each["dt"]=dt.strftime("%c")
        return result
config = SinglenetConfig(const.DATAFILE)
