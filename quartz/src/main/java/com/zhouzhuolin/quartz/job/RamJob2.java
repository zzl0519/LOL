package com.zhouzhuolin.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 小李飞刀
 * @site www.javaxl.com
 * @company
 * @create  2019-11-14 9:32
 */
public class RamJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println(format.format(new Date())+" : 基于RAM的quartz调度框架定时任务...");

        try {
            Thread.sleep(20*1000);
            System.out.println("模拟正在处理大数据....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}