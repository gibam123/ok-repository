package pe.gianfranco.retobcp.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import pe.gianfranco.retobcp.api.entities.ExchangeRateEntity;
import pe.gianfranco.retobcp.api.mappers.ExchangeRateMapper;
import pe.gianfranco.retobcp.api.model.ExchangeRateDTO;
import pe.gianfranco.retobcp.api.repositories.ExchangeRateRepository;

@Lazy
@Service("BD")
public class ExchangeRateServiceImpl implements ExchangeRateService {
	
	@Autowired
	private ExchangeRateMapper exchangeRateMapper;
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	@Override
	public ExchangeRateDTO getExchangeRateDTO(double amount, String originCurrency, String destinationCurrency) {
		ExchangeRateEntity exchangeRateEntity = exchangeRateRepository.getExchangeRateDTO(originCurrency, destinationCurrency);
		
		ExchangeRateDTO exchangeRateDTO = exchangeRateMapper.getExchangeRateDTO(exchangeRateEntity);
		exchangeRateDTO.setAmount(amount);
		exchangeRateDTO.setExchangeRateAmount(exchangeRateDTO.getExchangeRate() * amount);
		
		return exchangeRateDTO;
	}

	@Override
	public ExchangeRateDTO updateExchangeRate(ExchangeRateDTO exchangeRateDTO) {
		ExchangeRateEntity exchangeRateEntity = exchangeRateMapper.getExchangeRateEntity(exchangeRateDTO);
		exchangeRateEntity = exchangeRateRepository.save(exchangeRateEntity);
		
		exchangeRateDTO = exchangeRateMapper.getExchangeRateDTO(exchangeRateEntity);

		return exchangeRateDTO;
	}
	
	@Override
	public Optional<ExchangeRateDTO> updateExchangeRate_2(Integer id, ExchangeRateDTO exchangeRateDTO) {
		
		Optional<ExchangeRateEntity> optExchangeRateEntity = exchangeRateRepository.findById(id);
		
		ExchangeRateEntity exchangeRateEntity = optExchangeRateEntity.get();		
		exchangeRateEntity.setExchangeRate(exchangeRateDTO.getExchangeRate());	
		
		exchangeRateEntity = exchangeRateRepository.save(exchangeRateEntity);
		
		exchangeRateDTO = exchangeRateMapper.getExchangeRateDTO(exchangeRateEntity);

		return Optional.of(exchangeRateDTO);
	}

}
