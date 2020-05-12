package com.fy.hot_topic_spider.service.impl;

import com.fy.hot_topic_spider.service.WeiboService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/1/7 15:49
 * @Description:
 */
@Service
public class WeiboServiceImpl implements WeiboService {
    @Override
    public List<String> getWeiboHotTopic() {

        List<String>  result =new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("https://s.weibo.com/top/summary?Refer=top_hot")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                    .timeout(5 * 1000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int size=0;
        Elements elementsByClass = document.getElementsByClass("td-02");
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
