package com.example.batchcrawler.quartz;

import java.text.ParseException;
import java.util.Date;
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
    public Trigger jobTrigger() throws ParseException {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(quartzJobDetail());
        trigger.setCronExpression("0 * * * * ?");
        trigger.afterPropertiesSet();
        return trigger.getObject();
    }
}
