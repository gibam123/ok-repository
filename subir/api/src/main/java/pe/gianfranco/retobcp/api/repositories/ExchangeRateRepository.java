package pe.gianfranco.retobcp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.gianfranco.retobcp.api.entities.ExchangeRateEntity;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Integer> {
	
	@Query(value="select * from t_exchangerate where origin_currency = ?1 and destination_currency = ?2", nativeQuery = true)
	public ExchangeRateEntity getExchangeRateDTO(String originCurrency, String destinationCurrency);

}
