package pe.gianfranco.retobcp.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "t_exchangerate")
public class ExchangeRateEntity {
	
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer Id;	
	
	private String originCurrency;	
	
	private String destinationCurrency;
	
	private double exchangeRate;

}
