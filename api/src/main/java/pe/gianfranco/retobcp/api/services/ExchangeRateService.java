package pe.gianfranco.retobcp.api.services;

import java.util.Optional;

import pe.gianfranco.retobcp.api.model.ExchangeRateDTO;

public interface ExchangeRateService {
	
	public ExchangeRateDTO getExchangeRateDTO(double amount, String originCurrency, String destinationCurrency);
	
	public ExchangeRateDTO updateExchangeRate(ExchangeRateDTO exchangeRateDTO);
	
	public Optional<ExchangeRateDTO> updateExchangeRate_2(Integer id, ExchangeRateDTO exchangeRateDTO);

}
