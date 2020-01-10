package com.fy.hot_topic_spider.config;

import com.fy.hot_topic_spider.service.BaiduSerivce;
import com.fy.hot_topic_spider.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2020/1/7 13:44
 * @Description:
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    private BaiduSerivce baiduSerivce;
    @Autowired
    private WeiboService weiboService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("开始自动采集data----");
        while(true){
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(Calendar.HOUR_OF_DAY);
            if(i==9 || i==14 || i==20){
                getBaidHotTopicAndSendEmail();
                getWeiboHotTopicAndSendEmail();
                TimeUnit.HOURS.sleep(2);
            }else{
                TimeUnit.SECONDS.sleep(30);
            }
        }
    }

    public  void getBaidHotTopicAndSendEmail(){

        StringBuilder content =new StringBuilder();
        System.err.println("ApplicationRunner------------");
        List<String> baiduHotTopic = baiduSerivce.getBaiduHotTopic();
        for (String s : baiduHotTopic) {
            content.append(s).append("\r\n");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("676176407@qq.com");
        message.setSubject("百度热搜");
        message.setText(content.toString());
        jms.send(message);

    }

    public void getWeiboHotTopicAndSendEmail(){
        StringBuilder content =new StringBuilder();
        System.err.println("ApplicationRunner------------");
        List<String> baiduHotTopic = weiboService.getWeiboHotTopic();
        for (String s : baiduHotTopic) {
            content.append(s).append("\r\n");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        //改成收件人的邮箱
        message.setTo("xxxx@qq.com");
        message.setSubject("微博");
        message.setText(content.toString());
        jms.send(message);
    }

}
