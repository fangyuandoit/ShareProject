from django.db import models

# Create your models here.
class houseinfo(models.Model):
    # db_table = 'houseinfo'
    id=models.AutoField(primary_key=True)
    selling_house_number = models.IntegerField(default=0)
    trade_number_last90day = models.IntegerField(default=0)
    house_avg_price = models.IntegerField(default=0)
    increase_house = models.IntegerField(default=0)
    increase_people = models.IntegerField(default=0)
    people_seehouse_number = models.IntegerField(default=0)
    create_time = models.DateTimeField(auto_now_add=True)
