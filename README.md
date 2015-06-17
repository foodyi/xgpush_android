# 信鸽推送ane
android版信鸽推送 ane
目前实现了信鸽的注册、设置标签、删除标签、本地推送相关接口，
当前依赖信鸽sdk的版本是2.4

## 出发点和计划
项目是使用业余时间开发，本身作者目前并不使用信鸽做项目，考虑没有合适的开源推送ane项目，而每个开发者从头
了解掌握ane需要一定的时间，决定写信鸽的ane,之前写了ios版本的，有一些tx问我有没有android,现在就放出来给大家。
如果这个项目能够帮助到大家或者它的存在有意义，我会坚持一直维护下去，信鸽官方出新版本我也会尽快跟进。

## 使用
大家可以看一下test文件夹中的测试代码以及工程配置文件

` XGPush.getInstance().create() //单例模式，调用build()初始化信鸽调用ane环境 `

` XGPush.getInstance().registerPush(); //注册设备，注册成功后会发送XGPushEvent `

` XGPush.getInstance().setTag("test") //设置标签`

` XGPush.getInstance().delTag("test") //删除标签`

` XGPush.getInstance().addLocalNotification("本地通知","测试一下","20150617","15","18"); //本地通知`

## 测试手机
红米note2

## 捐赠
从开发到调试花费了不少时间和精力，希望大家给我不断更新的动力 ^_^

想捐赠的朋友请转给我的支付宝账号 **foodyi@163.com**
