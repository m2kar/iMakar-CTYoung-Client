# -*- coding: gbk -*-
"""

"""
#   @Time:  2017/8/30 14:54
#   @Author:still_night@163.com
#   @File:  cmd_ctyoung.py
from core import SinglenetSession, User
import sys

default_encoding = sys.getdefaultencoding()


def cmd_login():
    print("请将设备连入ct-young,\n并输入想要登陆ct-young的设备的ip,用户名,密码并按回车确认\n")
    userip = str(raw_input(">>ip: ").decode(default_encoding).strip())
    username = str(raw_input(">>账号: ").decode(default_encoding).strip())
    password = str(raw_input("密码:  ").decode(default_encoding).strip())
    print("请确认 \nip:{0}\n用户名{1}\n密码:{2}\n  ".format(userip, username, password))
    yes = raw_input("按y继续,或者任意键取消").decode(default_encoding).strip().upper()
    if yes == 'Y':
        print("开始登陆")
        session = SinglenetSession(userip=userip, user=User(username, password))
        if session.login():
            print("登陆成功 \n user:{}\nip:{}\nuuid: {} \n请妥善保存ip 和 uuid用于注销\n".format(session.user.username, session.userip,session.uuid))
        else:
            print("登陆失败:错误{}\n".format(session.login_response_code))


def cmd_logout():
    print("请输入登陆时的ip和uuid来进行注销\n")
    userip = str(raw_input(">>ip: ").decode(default_encoding).strip())
    uuid = str(raw_input(">>uuid:  ").decode(default_encoding).strip())
    print("正在注销 \nip:{} \nuuid:{}".format(userip, uuid))
    session = SinglenetSession(uuid=uuid, userip=userip)
    if session.logout():
        print("注销成功 \n ip:{}\n".format(userip))
    else:
        print("注销失败 : ip:{}  {} ".format(userip, session.get_code_msg(session.logout_response_code)))


def cmd_run():
    print("""
    医大校园网CT-Young登陆器

    1.登陆
    2.注销
    请选择你的操作然后按回车键继续
    """)
    choice = str(raw_input("").decode(default_encoding).strip())
    if choice == "1":
        cmd_login()
    elif choice == "2":
        cmd_logout()
    else:
        print("输入有误,程序退出")
    raw_input("按任意键继续....")


if __name__ == '__main__':
    # s=SinglenetSession()
    # s.post("http://www.baidu.com")
    # u=User("edu189","154914")
    # print u.en_password
    # edu18940248503
    # 154914
    # session = SinglenetSession(userip="100.76.168.214", user=User("edu18940248503", "154914"))
    # session.login()
    try:
        cmd_run()
    except Exception as e:

        print("{}: {}".format(e.__class__.__name__,e))
        raw_input()
        raise

