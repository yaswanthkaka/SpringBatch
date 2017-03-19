package com.company.proj.batch.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PortfolioFieldSetMapper implements FieldSetMapper<Portfolio> {

	@Override
	public Portfolio mapFieldSet(FieldSet fieldSet) throws BindException {
		return new Portfolio(fieldSet.readString("fiscal_year"),
				fieldSet.readString("accouting_period"),
				fieldSet.readString("data_soruce"));
	}

}
