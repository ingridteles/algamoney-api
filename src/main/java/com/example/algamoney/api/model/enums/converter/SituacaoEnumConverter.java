package com.example.algamoney.api.model.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.algamoney.api.model.enums.Situacao;

@Converter(autoApply = true)
public class SituacaoEnumConverter implements AttributeConverter<Situacao, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Situacao situacao) {
		return situacao.getCod();
	}

	@Override
	public Situacao convertToEntityAttribute(Integer dbData) {
		return Situacao.toEnum(dbData);
	}
}
