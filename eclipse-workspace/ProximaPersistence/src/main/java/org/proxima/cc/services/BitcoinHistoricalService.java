package org.proxima.cc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.proxima.cc.entities.CryptoExchangeValuesProvider;
import org.proxima.cc.entities.bitcoin.BitcoinHistorical;
import org.proxima.cc.entities.bitcoin.BitcoinHistoricalCustom;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;
import org.proxima.cc.repository.ProvidersRepository;
import org.proxima.cc.repository.bitcoin.BitcoinHistoricalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitcoinHistoricalService {

	public static final Logger logger = Logger.getLogger(BitcoinHistoricalService.class);

	@Autowired
	private BitcoinHistoricalRepository bitcoinHistoricalRepository;
	@Autowired
	private ProvidersRepository providersRepository;

	public List<BitcoinHistorical> listAllBitcoinHistoricals() {
		return bitcoinHistoricalRepository.findAll();
	}

	public BitcoinHistorical getMinLastDayBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		BitcoinHistorical bitcoin = bitcoinHistoricalRepository
				.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueAsc(ldt, id);
		return bitcoin;
	}
	
	public BitcoinHistorical getMaxLastDayBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		BitcoinHistorical bitcoin  = bitcoinHistoricalRepository
				.findFirstByExchangetimeGreaterThanAndCryptoexchangevaluesprovideridOrderByExchangevalueDesc(ldt, id);
		return bitcoin;
	}
	
	public BitcoinHistoricalCustom getAverageLastDayBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		BitcoinHistoricalCustom bitcoin = bitcoinHistoricalRepository
				.findAverageByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return bitcoin;
	}
	
	public List<BitcoinHistorical> listAllLastDayBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAllLastDayBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusDays(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAllLastWeekBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAllLastWeekBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusWeeks(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return bitcoins;
	}
	
	

	public BitcoinHistoricalCustom getLastExcangeByProviderIdAndCurrencyId(Long providerId, Long currencyId) {
		return bitcoinHistoricalRepository.findLastExchangeByProviderIdAndCurrency(providerId, currencyId);
	}
	
	
	
	public List<BitcoinHistoricalCustom> getLastExchangeValuesByCurrencyId(Long currencyId) {
		
     	List<BitcoinHistoricalCustom> toReturn = new ArrayList<BitcoinHistoricalCustom>();
		
		List <CryptoExchangeValuesProvider> provList = providersRepository.findAll();
		System.out.println(provList.size());
		
		System.out.println("ciclo sulla lista dei provider");
		for (int i = 0; i<provList.size(); i++) {
			
			long provId = provList.get(i).getId();
			System.out.println("aggiungo ogni provider a lista");
			//per ogni provider faccio bitcoinHistoricalRepository.findByLastExcangeByProviderIdAndCurrency(providerId, currencyId);
			//ed aggiungo il risultato alla lista "toReturn..."	
			toReturn.add(bitcoinHistoricalRepository.findLastExchangeByProviderIdAndCurrency(provId, currencyId));
		
		}
			
		return toReturn;
	}

	public List<BitcoinHistorical> listAlllastMonthBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAlllastMonthBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusMonths(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAlllastYearBitcoinHistoricals() {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository.findAllByExchangetimeGreaterThan(ldt);
		return bitcoins;
	}

	public List<BitcoinHistorical> listAlllastYearBitcoinHistoricals(Long id) {
		LocalDateTime ldtNow = LocalDateTime.now();
		LocalDateTime ldt = ldtNow.minusYears(1);
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalRepository
				.findAllByExchangetimeGreaterThanAndCryptoexchangevaluesproviderid(ldt, id);
		return bitcoins;
	}

	public void insertBitcoinHistorical(final BitcoinHistorical bitcoin) {
		logger.info("Insert BitcoinHistorical: " +  bitcoin);
		bitcoinHistoricalRepository.save(bitcoin);
	}
}
