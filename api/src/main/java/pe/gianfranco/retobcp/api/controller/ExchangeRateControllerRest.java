package pe.gianfranco.retobcp.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.gianfranco.retobcp.api.model.ExchangeRateDTO;
import pe.gianfranco.retobcp.api.services.ExchangeRateService;

@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateControllerRest {
	
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	
	@GetMapping
	public ResponseEntity<ExchangeRateDTO> getExchangeRateDTO(@RequestParam double amount,
															  @RequestParam String originCurrency,
															  @RequestParam String destinationCurrency) {
		ExchangeRateDTO exchangeRateDTO = exchangeRateService.getExchangeRateDTO(amount, originCurrency, destinationCurrency);
		return ResponseEntity.ok(exchangeRateDTO);
	}
	
	@PostMapping
	public ResponseEntity<ExchangeRateDTO> update(@RequestBody ExchangeRateDTO exchangeRateDTO) {
		exchangeRateDTO = exchangeRateService.updateExchangeRate(exchangeRateDTO);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(exchangeRateDTO.getId())
						.toUri();
		
		return ResponseEntity.ok(exchangeRateDTO);
	}
	
	@PatchMapping("/{id}")
	//@PatchMapping(value = "/book/{id}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExchangeRateDTO> patch(@PathVariable Integer id, @RequestBody ExchangeRateDTO exchangeRateDTO) {

		Optional<ExchangeRateDTO> optExchangeRateDTO = exchangeRateService.updateExchangeRate_2(id, exchangeRateDTO);	
		
		ExchangeRateDTO userDTO = optExchangeRateDTO.orElseThrow(NoSuchElementException::new);

        return ResponseEntity.ok(userDTO);
    }
	
	

}
