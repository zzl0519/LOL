package com.zhouzhuolin.quartz.quartz01;

import com.zhouzhuolin.quartz.job.RemJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-01 23:14
 */
public class Demo4 {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
//        调度器创建
        Scheduler scheduler = factory.getScheduler();

//        具体定时任务需要执行的代码
        JobDetail jobDetail = newJob(RemJob.class)
                .withIdentity("job1","group1")
                .withIdentity("这是一个作业类案例")
                .build();

        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("name","雪中悍刀行");
        jobDataMap.put("zuozhe","烽火戏诸侯");


        Trigger trigger = (Trigger) TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/8 * * * * ? *"))
//                触发器标识
                .withIdentity("trigger1","group1")
                .withDescription("这是一个触发器")
                .build();

//       调度工厂绑定作业类及触发器
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }


}
