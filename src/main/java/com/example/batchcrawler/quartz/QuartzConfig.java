package com.example.batchcrawler.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzJobDetail() {
        return JobBuilder.newJob(WebCrawlingQuartzJobBean.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger jobTrigger() {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(600).withRepeatCount(1);

        return TriggerBuilder.newTrigger()
                .forJob(quartzJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
