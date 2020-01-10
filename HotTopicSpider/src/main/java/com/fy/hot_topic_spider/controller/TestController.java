package com.fy.hot_topic_spider.controller;

import com.fy.hot_topic_spider.service.BaiduSerivce;
import com.fy.hot_topic_spider.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Date: 2020/1/8 10:13
 * @Description:
 */
@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    private BaiduSerivce baiduSerivce;
    @Autowired
    private WeiboService weiboService;


    @RequestMapping("test")
    public Object test(){
        return new Date().toLocaleString();
    }



    @RequestMapping("getBaidu")
    public Object getBaidu(){
       return  baiduSerivce.getBaiduHotTopic();
    }


    @RequestMapping("sendEmail")
    public Object sendEmail(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("676176407@qq.com");
        message.setSubject("百度热搜");
        message.setText("hello kitty");
        jms.send(message);
         return "ok";
    }



}
