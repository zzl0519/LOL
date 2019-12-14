package com.zhouzhuolin.quartz.quartz01;

import com.zhouzhuolin.quartz.job.RamJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

/**
 * @author 小李飞刀
 * @site www.javaxl.com
 * @company
 * @create  2019-11-14 9:33
 */
public class Demo66 {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
//        调度器创建
        Scheduler scheduler = factory.getScheduler();

//        具体定时任务需要执行的代码
        JobDetail jobDetail = newJob(RamJob2.class)
                .withIdentity("job2", "group1")
                .withIdentity("这是一个作业类案例")
                .build();

        Trigger trigger = (Trigger) TriggerBuilder.newTrigger()
//                每10s执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
//                触发器标识
                .withIdentity("trigger2", "group1")
                .withDescription("这是一个触发器")
                .build();

//       调度工厂绑定作业类及触发器
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}