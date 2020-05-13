#!/usr/bin/python
from service.GetLoveWord import findLoveWord
from service.SendEmail import sendMessage

word = findLoveWord()[:1]
for w in word:
    sendMessage(w)
