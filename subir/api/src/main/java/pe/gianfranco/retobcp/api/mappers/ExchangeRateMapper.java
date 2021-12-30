package pe.gianfranco.retobcp.api.mappers;

import org.mapstruct.Mapper;

import pe.gianfranco.retobcp.api.entities.ExchangeRateEntity;
import pe.gianfranco.retobcp.api.model.ExchangeRateDTO;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
	
	public ExchangeRateDTO getExchangeRateDTO(ExchangeRateEntity exchangeRateEntity);
	
	public ExchangeRateEntity getExchangeRateEntity(ExchangeRateDTO exchangeRateDTO);

}
