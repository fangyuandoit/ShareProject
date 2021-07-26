
from faker import Faker
fake = Faker()

print(fake.name())
print(fake.address())
print(fake.chrome())
print(fake.date())
print(fake.ascii_free_email())
print(fake.latitude())
print(dir(fake))   # 查看哪些能够生成假数据  排除_ 开始和结束的


# 指定语言
fake = Faker("zh_CN")
print(fake.name())
print(fake.address())
print(fake.phone_number())
print(fake.email())


def fun1():
    print(123)