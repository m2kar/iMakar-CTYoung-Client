# -*- coding: utf-8 -*- 
"""

"""
#   @Time:  2017/8/30 21:24
#   @Author:still_night@163.com
#   @File:  config.py

from __future__ import unicode_literals
import json
import os
import datetime
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
        ip
        uuid
        username
        t

    """

    def __init__(self, json_file=const.DATAFILE):
        log.debug("init Config")
        self.json_file = json_file
        self.conf_dict = {"Users": {}, "Sessions": []}
        self.read()
        self.write()

    def __del__(self):
        log.debug("del Config")
        self.write()

    def read(self, json_file=None):
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
        self.conf_dict["Users"].update(adict.get("Users", {}))
        for new in adict.get("Sessions", []):
            for old in self.conf_dict["Sessions"]:
                if cmp(new, old) == 0:
                    break
            else:
                self.conf_dict["Sessions"].append(new)
        self.write()

    def write(self, filename=None):
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

    def add_session(self, userip, uuid, username=None, t=datetime.datetime.now().isoformat()):
        self.conf_dict["Sessions"].append({"userip": userip, "uuid": uuid, "username": username, "t": t})
        self.write()

    def remove_session(self, userip, uuid):
        for i, session in enumerate(self.conf_dict["Sessions"]):
            if userip == session['userip'] and uuid == session['uuid']:
                self.conf_dict.pop(i)
        self.write()

    def remove_session_by_index(self, index):
        self.conf_dict["Sessions"].pop(index)
        self.write()

    @property
    def sessions(self):
        return self.conf_dict['Sessions']


config = SinglenetConfig(const.DATAFILE)
"""
[main]
UserCount=2
SessionCount=3

[User:0]
username=edu000123
password=hello

[

"""
