package com.zhouzhuolin.quartz.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SpringTask {
    @Scheduled(cron = "0/10 * * * * ?")
    public void xxx(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println(format.format(new Date())+" : 这是一个spring task...");

        try {
            Thread.sleep(20*1000);
            System.out.println("模拟正在处理大数据....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}