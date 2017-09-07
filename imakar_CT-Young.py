# -*- coding: utf-8 -*- 
"""

"""
#   @Time:  2017/8/31 2:48
#   @Author:still_night@163.com
#   @File:  imakar_CT-Young.py

from __future__ import unicode_literals

import log

from Tkinter import *
from tkFont import Font
from tkSimpleDialog import Dialog
from webbrowser import open_new_tab
# from base64 import b64decode
# from os import getenv
import socket
import re
import threading
import time

import const
from core import User, SinglenetSession,NetworkError,LoginError
from config import config

def get_localip():
    try:
        result=re.findall(r"(100\.\d{1,3}\.\d{1,3}\.\d{1,3})",str(socket.gethostbyname_ex(socket.gethostname())))
        if result:
            return result[0]
    except Exception:
        log.trace_error()
    return ""


class SinglenetMainApp:
    def __init__(self, master):
        log.debug("init {}".format(self.__class__.__name__))
        self.master = master
        w = Frame(master,padx=20,pady=20)
        w.master.title(const.title)

        self.size = (280, 700)

        master.maxsize(*self.size)
        master.minsize(self.size[0],300)
        master.resizable(0, 0)
        w.grid()
        self.w = w
        self.std_font=("微软雅黑",15)
        Label(w, text="CT-Young 客户端", font=("微软雅黑",20), pady=20).grid()
        self.icon()
        self.input_area()
        self.btn_area()
        self.message()
        self.help()

    def icon(self):
        log.debug("set icon")
        icopath=r'network.ico'
        # with open(icopath,"w+") as fp:
        #     fp.write(b64decode(const.str_ico))
        try:
            self.master.iconbitmap(icopath)
        except TclError as e:
            log.error("icon set error {},{}".format(e,icopath))
            self.master.iconbitmap()


    def btn_area(self):
        btns = Frame(self.w, padx=10, pady=20)
        btns.grid()
        self.btn_login = Button(btns, text="登陆",command=self.login ,padx=20,pady=5,font=self.std_font)
        # self.btn_login.bind("<Button-1>",lambda callback:self.btn_login.config(state=DISABLED))
        # self.btn_login.bind("<ButtonRelease-1>",lambda callback:self.login())
        self.btn_login.grid(row=0, column=0)
        self.btn_logout = Button(btns, text="注销", command=self.logout,padx=20,pady=5,font=self.std_font)
        self.btn_logout.grid(row=0, column=1)

    def input_area(self):
        area = Frame(self.w)
        area.grid()
        # input_font=Font(self.master)
        for index, (name, var, default) in enumerate(
                [("ip:", "ip", get_localip()), ("账号:", "username", config.username), ("密码:", "password", config.password)]):
            Label(area, text=name,font=self.std_font).grid(row=index + 1, column=0)
            self.__dict__[var] = StringVar(value=default)
            Entry(area, width=15, textvariable=self.__dict__[var],font=self.std_font).grid(row=index + 1, column=1, pady=10)

    def help(self):
        help = Button(self.master, text="帮助  @imakar",relief=FLAT,command=lambda : HelpDialog(self.master).mainloop())
        help.grid(sticky=S)

    def message(self):
        self.message_box = StringVar()
        self.max_message_width=36
        self.max_message_height=10
        self.min_message_height=3
        # self.set_message("")
        self.set_message("")
        Message(self.w, textvariable=self.message_box, padx=10, width=self.size[0] - 20, font=("微软雅黑",8)).grid(
            columnspan=2, sticky=W + E)

    def set_message(self, s):
        log.info("message: {}".format(s))
        if not isinstance(s,(unicode,str)):
            self.set_message("")
        # s=""
        a=[]
        w=self.max_message_width
        for each in s.splitlines():
            i = 0
            while i + w < len(each):
                a.append(each[i:i + w])
                i +=w
            a.append(each[i:])
        if len(a)>self.max_message_height:
            log.info("message 溢出")
            a=a[:self.max_message_height]
        while not len(a)>=self.min_message_height:
            a.append("")
        self.message_box.set("\n".join(a))

    def login(self):
        threading.Thread(target=self._login).start()

    def _login(self):
        # if self.btn_login.cget("state")==DISABLED:
        #     log.debug("按钮btn_login已经点击")
        #     return
        self.btn_login.config(state=DISABLED)
        # if self.isinlogin:
        #     log.debug("按钮btn_login已经点击")

        self.set_message("正在初始化")
        # import time
        # log.info("sleep")
        # time.sleep(2)
        try:
            s = SinglenetSession(user=User(self.username.get().strip(), self.password.get().strip()), userip=self.ip.get().strip())
        except Exception as e:
            self.set_message("初始化错误!!:\n{}".format(e))
            log.trace_error()
        else:
            self.set_message("")
            try:
                result = s.login()
            except Exception as e:
                self.set_message("登陆错误!!: \n{}".format(e))
                log.trace_error()
            else:
                if result:
                    self.set_message("登陆成功 \n user:{}\nip:{}".format(s.user.username, s.userip))
                    config.set_user(s.user.username, s.user.password)
                    config.add_session(s.userip, s.uuid, s.user.username)
                else:
                    self.set_message(
                        "服务器返回失败代码{}\n原因:{}".format(s.login_response_code, s.get_code_msg(s.login_response_code)))
        finally:
            time.sleep(0.5)
            self.btn_login.config(state=NORMAL)


    def logout(self):
        self.btn_logout.config(state=DISABLED)
        try:
            sessions = config.sessions
            if len(sessions) == 0:
                self.set_message("未找到登录记录")
            else:
                select = self.select_session()
                if not select is None:
                    self.session_logout(sessions[select])
        except Exception as e:
            self.set_message("注销初始化错误:{}".format(e))
            log.trace_error()
        finally:
            self.btn_logout.config(state=NORMAL)


    def select_session(self):
        return SessionSelectDialog(self.master, "请选择").result

    def session_logout(self, session_dict):
        self.set_message("正在初始化")
        try:
            s = SinglenetSession(userip=session_dict['userip'], uuid=session_dict['uuid'])
        except Exception as e:
            self.set_message("初始化错误: {}".format(e))
            config.remove_session(session_dict["userip"], session_dict["uuid"])
        else:
            try:
                result = s.logout()

            except NetworkError as e:
                self.set_message("网络错误!!: \n{}".format(e))
                log.trace_error()
            except Exception as e:
                self.set_message("注销错误!!: \n{}".format(e))
                log.trace_error()
                config.remove_session(s.userip, s.uuid)
            else:
                if result:
                    self.set_message("注销成功 \n ip:{}".format(s.userip))
                    # config.set_user(s.user.username,s.user.password)
                    # config.add_session(s.userip,s.uuid,s.user.username)
                else:
                    self.set_message("已连接到服务器,但是注销失败了\n代码{},原因:{}".format(s.logout_response_code,
                                                                          s.get_code_msg(s.logout_response_code)))
                config.remove_session(s.userip, s.uuid)


class SessionSelectDialog(Dialog):
    # def __init__(self,master):
    #     tkSimpleDialog.Dialog.__init__(self,master,"选择")
    #     master.resizable(0,0)

    def body(self, master):
        # self.master.title="选择"
        # config(self,)
        self.resizable(0, 0)
        Label(master, text="请选择要注销的登陆").pack()
        self.listbox = Listbox(master, width=40)
        self.listbox.pack(fill=BOTH, expand=1)
        sessions = config.sessions
        for each in sessions:
            showstr = ""
            showstr += "ip:{}  ".format(each.get('userip'))
            if each.get("username"):
                showstr += "账号:{}  ".format(each['username'])
            showstr += "时间:{}".format(each["dt"])
            self.listbox.insert(END, showstr)

    def buttonbox(self):
        box = Frame(self)
        w = Button(box, text="确认", width=10, command=self.ok, default=ACTIVE)
        w.pack(side=LEFT, padx=5, pady=5)
        w = Button(box, text="取消", width=10, command=self.cancel)
        w.pack(side=LEFT, padx=5, pady=5)

        self.bind("<Return>", self.ok)
        self.bind("<Escape>", self.cancel)

        box.pack()


    def apply(self):
        select = self.listbox.curselection()
        if len(select) == 0:
            self.result=None
        else:
            self.result=int(select[0])

class HelpDialog(Dialog):
    def __init__(self,master):
        # self.resizable(0, 0)
        Dialog.__init__(self, master, title="帮助")

    def body(self, master):
        # self.config()
        self.resizable(0,0)
        # img = ImageTk.PhotoImage(Image.open("qrcode.jpg"))
        # Label(master, image=img).grid()
        self.help_message=StringVar()
        self.help_message.set(const.help)
        Message(master, textvariable=self.help_message).grid(row=0, column=0, rowspan=2)
        links=Frame(master)
        links.grid(row=0,column=1)
        mainpage="https://github.com/still-night/iMakar-CTYoung-Client"
        LinkLabel(links,text="更多帮助",link=mainpage+"/wiki").grid()
        LinkLabel(links,text="项目主页",link=mainpage).grid()
        LinkLabel(links,text="作者博客",link="http://blog.csdn.net/still_night").grid()
        LinkLabel(links,text="获取更新",link=mainpage+"/releases").grid()
        Label(links,text="作者:iMakar , CMU小孩 ").grid()
        Label(links,text="邮箱:iMakar@qq.com").grid()
        Label(links,text=" ").grid()
        Label(links,text="微信公众平台").grid()
        # photostr="""a75Xfd7v2gvrjS9/nqT6ouw/B+UKoD6AAQHs69/Pv3///Pmlpt5BAQyg33byIVTggeGdFd09+gkAQGoPEmTPgxFOKBpC/nXY34UEeSjiiB3qZU9mAxRwHwD5keiifi0OkCBB+RlYwACYccdQjQDcmOOMdeUoDz33GRiAAd6dJSSRAxiJ5EIvdhiaPUPe12KUWB4oWXH6LcBiAGCGKeaYZJYZ5ooAKJdkQQB4ad9sOkLpZn1wAmkQOwR5eeZxsSGE50B6ggkAnzOaaWiZ9/wpkJcDCCCAmI8eKumhGsl3IoRGspjlixIG8F5CAK6YY5AEamrgqKDpBlxmK0ooQIU="""
        # photo=PhotoImage(data=photostr)
        # image=Image.open("qrcode3.jpg")
        # Label(master,image=ImageTk.PhotoImage(image)).grid()
        Label(master, image=img).grid(row=1,column=1)


    def buttonbox(self):
        pass

class LinkLabel(Label):
    def __init__(self, master=None, link="", cnf={}, **kw):
        Label.__init__(self,master=master,cnf=cnf,**kw)
        self.link=link
        self.config(foreground="blue", font=Font(underline=1))
        self.bind("<Button-1>",self.down)
        self.bind("<ButtonRelease-1>",self.up)

    def down(self,callback):
        self.config(foreground="red")

    def up(self,callback):
        self.config(foreground="blue")
        self.browse()

    def browse(self):
        open_new_tab(self.link)
        log.info("open webpage {}".format(self.link))

if __name__ == '__main__':
    try:
        root = Tk()
        img = PhotoImage(data=const.str_wxcode)
        login = SinglenetMainApp(root)
        root.mainloop()
    except Exception as e:
        log.trace_error()
        log.error("异常退出 {}".format(e))
        raise
