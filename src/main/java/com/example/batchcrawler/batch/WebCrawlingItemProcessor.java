package com.example.batchcrawler.batch;

import com.example.batchcrawler.entity.BaeMinEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class WebCrawlingItemProcessor implements ItemProcessor<List<BaeMinEntity>, List<BaeMinEntity>> {
    @Override
    public List<BaeMinEntity> process(List<BaeMinEntity> items) throws Exception {
        List<BaeMinEntity> processedItems = items.stream()
                .collect(Collectors.toList());
        return processedItems;
    }
}
