#!/usr/bin/python3
import requests
from bs4  import BeautifulSoup


# 返回多条语录
def findLoveWord():
    url ="http://www.1juzi.com/new/150542.html"
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36 QIHU 360SE",
    }

    content = requests.get(url, headers=headers, verify=False).content.decode("gb2312",errors="ignore")
    soup = BeautifulSoup(content, 'html.parser')
    contentDocument = soup.find(class_="content").find_all("p")[:50]
    loveList=[];
    for dom in contentDocument:
        domString = dom.string
        domString =  domString[domString.index("、")+1:]
        loveList.append(domString)

    return loveList


