import json

from django.core import serializers
from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
from house.models import houseinfo
from house.service.GetHouseInfoBySpiderService import getHouseNumber_Price_hot


def fangjia(request):
    return render(request, 'fangjia.html')








def  findAllFangjiaInfo(request):
    # objects_all = houseinfo.objects.first()
    # print(json.dumps(objects_all))
    queryset = houseinfo.objects.all()
    # 2. 将数据序列化成json格式
    data = serializers.serialize('json', queryset=queryset)
    return   HttpResponse(data)

def  getTodayHouseInfo(request):
        print(888);
        houseInfoEntity = getHouseNumber_Price_hot()
        houseinfo.objects.create(selling_house_number=houseInfoEntity.selling_house_number
                                 ,trade_number_last90day=houseInfoEntity.trade_number_last90day
                                 ,house_avg_price=houseInfoEntity.house_avg_price
                                 ,increase_house=houseInfoEntity.increase_house
                                 ,increase_people=houseInfoEntity.increase_people
                                 ,people_seehouse_number=houseInfoEntity.people_seehouse_number
                                 )

        return HttpResponse("保存成功")
