package com.example.batchcrawler;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BatchcrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchcrawlerApplication.class, args);
    }

}
