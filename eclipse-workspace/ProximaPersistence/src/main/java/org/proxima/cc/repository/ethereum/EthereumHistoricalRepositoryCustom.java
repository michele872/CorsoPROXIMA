
package org.proxima.cc.repository.ethereum;

import java.time.LocalDateTime;

import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.proxima.cc.entities.litecoin.LitecoinHistoricalCustom;



public interface EthereumHistoricalRepositoryCustom  {
	
	
	EthereumHistoricalCustom findLastExchangeByProviderIdAndCurrency(Long providerId, Long currencyId);

	//	select AVG(exchangevalue) from bitcoinhistorical where cryptoexchangevaluesproviderid=7 AND exchangetime > '2018-03-19 11:23:03.0';
	// AVERAGE 
	EthereumHistoricalCustom findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(LocalDateTime ldt, Long id);
}
