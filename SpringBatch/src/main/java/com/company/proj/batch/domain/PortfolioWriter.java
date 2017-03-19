package com.company.proj.batch.domain;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

public class PortfolioWriter {
	@Bean
	public static ItemWriter<Portfolio> PortfolioItemWriter() throws Exception {
		FlatFileItemWriter<Portfolio> vcsPortfolioWriter = new FlatFileItemWriter<>();
		vcsPortfolioWriter.setResource(new FileSystemResource("E://my.csv"));
		
		DelimitedLineAggregator<Portfolio> lineAggregator = new DelimitedLineAggregator<>();
		FieldExtractor<Portfolio> fieldExtractor = createPortfolioFieldExtractor();
		lineAggregator.setFieldExtractor(fieldExtractor);
		vcsPortfolioWriter.setLineAggregator(lineAggregator);
		return vcsPortfolioWriter;
	}

	private static FieldExtractor<Portfolio> createPortfolioFieldExtractor() {
        BeanWrapperFieldExtractor<Portfolio> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[] {"fiscal_year", "accouting_period", "data_soruce"});
        return extractor;
	}
}
