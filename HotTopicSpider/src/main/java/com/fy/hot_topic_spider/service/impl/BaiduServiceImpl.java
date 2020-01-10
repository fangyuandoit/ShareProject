package com.fy.hot_topic_spider.service.impl;

import com.fy.hot_topic_spider.service.BaiduSerivce;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/1/7 13:59
 * @Description:
 */
@Service
public class BaiduServiceImpl implements BaiduSerivce {
    @Override
    public List<String> getBaiduHotTopic() {
        List<String>  result =new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("http://top.baidu.com/buzz?b=1&c=513&fr=topbuzz_b1_c513")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                    .timeout(5 * 1000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int size=0;
        Elements elementsByClass = document.getElementsByClass("list-title");
        if(elementsByClass.size()>30){
            size=30;
        }
        for(int i=0;i<size;i++){
            Element element = elementsByClass.get(i);
            result.add(element.text());
        }
        return result;
    }
}
