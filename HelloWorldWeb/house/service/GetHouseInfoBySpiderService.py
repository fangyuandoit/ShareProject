
import requests
import  re
from bs4  import BeautifulSoup

from house import models


def  getHouseNumber_Price_hot():
      url ="https://cd.lianjia.com/fangjia/"
      headers = {
          "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36 QIHU 360SE",
          "Referer": "https://cd.lianjia.com/chengjiao/",
          "Host": "cd.lianjia.com",
          "Connection":"close"
      }

      content = requests.get(url, headers=headers,verify=False).content.decode()
      soup = BeautifulSoup(content, 'html.parser')


      houseinfo = models.houseinfo;
      groups = re.search('>在售房源(.*?)套<', content, re.S)
      houseinfo.selling_house_number = groups.group(1)

      groups = re.search('>最近90天内成交房源(.*?)套<', content, re.S)
      houseinfo.trade_number_last90day = groups.group(1)

      numClass = soup.find_all(class_="num")
      for index, val in enumerate(numClass):
        if(index==0):
             houseinfo.house_avg_price = val.string
        if(index==1):
            # print(val.span.string)
            houseinfo.increase_house = val.span.string
        if (index == 2):
          # print(val.span.string)
          houseinfo.increase_people = val.span.string
        if (index == 3):
          # print(val.span.string)
          houseinfo.people_seehouse_number = val.span.string

      return houseinfo;





# houseInfo = getHouseNumber_Price_hot()
# print(houseInfo.toString(houseInfo))
# HousePriceDao.insertOneHouseInfo(houseInfo)