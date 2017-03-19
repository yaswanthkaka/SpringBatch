package com.company.proj.batch.domain;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PortfolioLineAggregator implements LineAggregator<Portfolio>{
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String aggregate(Portfolio item) {
		try {
			return objectMapper.writeValueAsString(item);
		}
		catch (JsonProcessingException e) {
			throw new RuntimeException("Unable to serialize Customer", e);
		}
	}

}
