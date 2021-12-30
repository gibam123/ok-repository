package pe.gianfranco.retobcp.api.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class ExchangeRateDTO {
	
	@NonNull
	private Integer Id;	
	
	//@NonNull
	private String originCurrency;	
	
	private String destinationCurrency;
	
	private double exchangeRate;
	
	private double amount;
	
	private double exchangeRateAmount;

}
