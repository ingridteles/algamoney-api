package com.example.algamoney.api.model.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.algamoney.api.model.enums.TipoLancamento;

@Converter(autoApply = true)
public class TipoLancamentoEnumConverter implements AttributeConverter<TipoLancamento, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoLancamento tipoLancamento) {
		return tipoLancamento.getCod();
	}

	@Override
	public TipoLancamento convertToEntityAttribute(Integer dbData) {
		return TipoLancamento.toEnum(dbData);
	}
}
