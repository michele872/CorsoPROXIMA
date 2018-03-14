package org.proxima.cc.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.proxima.cc.entities.BitcoinHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinHistoricalRepository extends JpaRepository<BitcoinHistorical, Integer>, JpaSpecificationExecutor<BitcoinHistorical>, BitcoinHistoricalRepositoryCustom {

	List<BitcoinHistorical> findAllByExchangetimeGreaterThan (LocalDateTime ldt);
	List<BitcoinHistorical> findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, BigInteger id);

	
}
