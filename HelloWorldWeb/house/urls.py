from django.urls import path

import house.views

urlpatterns = [
    path('fangjia', house.views.fangjia),
    path('findAllFangjiaInfo', house.views.findAllFangjiaInfo),
    path('getTodayHouseInfo', house.views.getTodayHouseInfo),

]