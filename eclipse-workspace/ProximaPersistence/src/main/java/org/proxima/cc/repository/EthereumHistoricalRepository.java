package org.proxima.cc.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.EthereumHistorical;
import org.proxima.cc.entities.LitecoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EthereumHistoricalRepository extends JpaRepository<EthereumHistorical, Integer> {

	List<EthereumHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt) ;
	List<EthereumHistorical> findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, BigInteger id);
}
