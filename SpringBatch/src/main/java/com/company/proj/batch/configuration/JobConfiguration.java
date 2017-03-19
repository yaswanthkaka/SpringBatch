/**
 * 
 */
package com.company.proj.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.company.proj.batch.domain.Portfolio;
import com.company.proj.batch.domain.PortfolioFieldSetMapper;
import com.company.proj.batch.domain.PortfolioWriter;

/**
 * @author Yaswanth
 *
 */
@Configuration
public class JobConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<Portfolio> portfolioItemReader() {
		FlatFileItemReader<Portfolio> reader = new FlatFileItemReader<>();
		int [] columnIndex = {0,1,3};
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("/data/sample.csv"));
		
		DefaultLineMapper<Portfolio> PortfolioLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer("~");
		tokenizer.setNames(new String[] {"fiscal_year", "accouting_period", "data_soruce"});
		tokenizer.setIncludedFields(columnIndex);
		
		PortfolioLineMapper.setLineTokenizer(tokenizer);
		PortfolioLineMapper.setFieldSetMapper(new PortfolioFieldSetMapper());
		PortfolioLineMapper.afterPropertiesSet();

		reader.setLineMapper(PortfolioLineMapper);

		return reader;
	}
	
	@Bean
	public Step step1() throws Exception {
		return stepBuilderFactory.get("PortfolioFileTransformerStep")
				.<Portfolio, Portfolio>chunk(10)
				.reader(portfolioItemReader())
				.writer(PortfolioWriter.PortfolioItemWriter())
				.build();
	}

	@Bean
	public Job job() throws Exception {
		return jobBuilderFactory.get("job")
				.start(step1())
				.build();
	}
	
}
