package com.example.batchcrawler.batch;

import com.example.batchcrawler.entity.BaeMinEntity;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebCrawlingItemProcessor implements ItemProcessor<List<BaeMinEntity>, List<BaeMinEntity>>, StepExecutionListener {
    @Override
    public List<BaeMinEntity> process(List<BaeMinEntity> items) throws Exception {

        return items;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("==========Process Start=========");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("==========Process End=========");
        return StepExecutionListener.super.afterStep(stepExecution);
    }
}
