#!/usr/bin/python
# -*- coding: UTF-8 -*-

import smtplib
from email.mime.text import MIMEText
from email.header import Header

# 第三方 SMTP 服务
mail_host = "smtp.qq.com"  # 设置服务器
mail_user = "xxx@qq.com"  # 用户名
mail_pass = "xxx"  # 口令

def sendMessage(msg):
    sender = 'xxx@qq.com'
    receivers = ['xxx@qq.com']  # 接收邮件，可设置为你的QQ邮箱或者其他邮箱

    message = MIMEText(msg, 'plain', 'utf-8')
    message['From'] = Header("情话", 'utf-8')
    message['To'] = Header("接收人", 'utf-8')

    message['Subject'] = Header('情话团', 'utf-8')

    try:
        smtpObj = smtplib.SMTP()
        smtpObj.connect(mail_host, 25)  # 25 为 SMTP 端口号
        smtpObj.login(mail_user, mail_pass)
        smtpObj.sendmail(sender, receivers, message.as_string())
        print("邮件发送成功")
    except smtplib.SMTPException as e:

        print("Error: 无法发送邮件" + e)