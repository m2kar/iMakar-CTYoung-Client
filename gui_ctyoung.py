# -*- coding: utf-8 -*- 
"""

"""
#   @Time:  2017/8/31 2:48
#   @Author:still_night@163.com
#   @File:  gui_ctyoung.py
from __future__ import unicode_literals
from Tkinter import *
import tkFont,tkMessageBox
from functools import partial
from core import User,SinglenetSession
from config import config
import log
# import traceback
class App:
    def __init__(self,master):
        frame=Frame(master)
        frame.pack()
        self.button=Button(
            frame,text="Quit",fg="red",command=frame.quit
        )
        self.button.pack(side=LEFT)

        self.hi_there=Button(frame,text="Hello",command=self.say_hi)
        self.hi_there.pack(side=LEFT)

    def say_hi(self):
        print "hi there, everyone!"

class SinglenetMainApp:
    def __init__(self,master):
        self.master=master
        w=Frame(master)
        w.master.title("CT-Young登陆器")
        size=(300,350)
        w.master.minsize(*size)
        w.master.maxsize(*size)
        w.grid()
        Label(w,text="CT-Young 登陆器",font=tkFont.Font(size=20),pady=20).grid(columnspan=2)
        for index,(name,var) in enumerate([("ip:","ip"),("账号:","username"),("密码:","password")]):
            Label(w, text=name).grid(row=index+1,column=0)
            self.__dict__[var]=StringVar()
            Entry(w, width=20, textvariable=self.__dict__[var]).grid(row=index+1,column=1,pady=10)
        btns=Frame(w,padx=10,pady=20)
        btns.grid(columns=2)
        self.btn_login=Button(btns,text="登陆",command=self.login,width=18,pady=10)
        self.btn_login.grid(row=0,column=0,columnspan=1)
        self.btn_logout=Button(btns,text="注销",command=self.logout,width=18,pady=10)
        self.btn_logout.grid(row=0,column=1,columnspan=1)
        self.message = StringVar()
        Label(w, textvariable=self.message, padx=10).grid(columnspan=2)

    def set_message(self,s):
        self.message.set(s)

    def login(self):
        self.set_message("正在初始化")
        try:
            s=SinglenetSession(user=User(self.username.get(),self.password.get()),userip=self.ip.get())
        except Exception as e:
            self.set_message("初始化错误!!:\n{}".format(e))
            log.trace_error()
        else:
            self.message.set("")
            try:
                result=s.login()
            except Exception as e:
                self.set_message("登陆错误!!: \n{}".format(e))
                log.trace_error()
            else:
                if result:
                    self.set_message("登陆成功 \n user:{}\nip:{}".format(s.user.username,s.userip))
                    config.set_user(s.user.username,s.user.password)
                    config.add_session(s.userip,s.uuid,s.user.username)
                else:
                    self.set_message("服务器返回失败代码{}\n原因:{}".format(s.login_response_code,s.get_code_msg(s.login_response_code)))

    def logout(self):
        sessions=config.sessions
        if len(sessions)==0:
            self.set_message("未找到登录记录")
            # tkMessageBox.showwarning("警告","未找到")
        elif len(sessions)==1:
            self.session_logout(sessions[0])
        else:
            self.session_logout(self.select_session())

    def select_session(self):
        return {}

    def session_logout(self,session_dict):
        self.set_message("正在初始化")
        try:
            s=SinglenetSession(userip=session_dict['userip'],uuid=session_dict['uuid'])
        except Exception as e:
            self.set_message("初始化错误: {}".format(e))
            config.remove_session(session_dict["userip"], session_dict["uuid"])
        else:
            try:
                result=s.logout()
            except Exception as e:
                self.set_message("注销错误!!: \n{}".format(e))
                log.trace_error()
            else:
                if result:
                    self.set_message("注销成功 \n ip:{}".format(s.userip))
                    # config.set_user(s.user.username,s.user.password)
                    # config.add_session(s.userip,s.uuid,s.user.username)
                else:
                    self.set_message("已连接到服务器,但是注销失败了\n代码{},原因:{}".format(s.login_response_code,s.get_code_msg(s.login_response_code)))
                config.remove_session(s.userip, s.uuid)
root=Tk()
# app=App(root)
login=SinglenetMainApp(root)
root.mainloop()
# root.destroy()