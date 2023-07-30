package com.example.batchcrawler.batch;

import com.example.batchcrawler.entity.BaeMinEntity;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@RequiredArgsConstructor
@EnableBatchProcessing
@Configuration
public class BatchConfig {
    private final EntityManagerFactory entityManagerFactory;


    private WebCrawlingItemProcessor processor() {
        return new WebCrawlingItemProcessor();
    }

    private WebCrawlingItemReader reader() {
        return new WebCrawlingItemReader();
    }

    private WebCrawlingItemWriter writer() {
        JpaItemWriter<BaeMinEntity> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return new WebCrawlingItemWriter<>(writer);
    }

    @Bean
    public Step webCrawlingStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        // StepBuilder 객체를 직접 생성
       return new StepBuilder("webCrawlingStep", jobRepository).<List<BaeMinEntity>, List<BaeMinEntity>> chunk(1, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job webCrawlingJob(JobRepository repository, JobCompletionNotificationListener listener,
                              Step webCrawlingStep, Step webCrawlingStep1) {
        return new JobBuilder("webCrawlingJob", repository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(webCrawlingStep)
                .build();
    }


}
