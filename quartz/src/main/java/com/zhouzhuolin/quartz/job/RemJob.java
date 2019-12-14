package com.zhouzhuolin.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-01 23:15
 */
public class RemJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务具体执行的业务逻辑代码");
//        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        System.out.println(jobDataMap.get("name").toString() + ":" + jobDataMap.get("zuozhe").toString());

    }
}
