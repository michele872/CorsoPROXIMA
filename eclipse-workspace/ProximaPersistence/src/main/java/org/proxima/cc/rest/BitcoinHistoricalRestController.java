package org.proxima.cc.rest;

import java.util.List;

import javax.validation.Valid;

import org.proxima.cc.entities.BitcoinHistorical;
import org.proxima.cc.entities.BitcoinHistoricalCustom;
import org.proxima.cc.services.BitcoinHistoricalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitcoin")
public class BitcoinHistoricalRestController {
	public static final Logger logger = LoggerFactory.getLogger(BitcoinHistoricalRestController.class);

    @Autowired
    BitcoinHistoricalService bitcoinHistoricalService;
	
	@GetMapping("/")
	public ResponseEntity<List<BitcoinHistorical>> listAllBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAllBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<BitcoinHistorical>> listAllLastDayBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAllLastDayBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins,HttpStatus.OK);
	}
	
//	@GetMapping("/lastDay")
//	public ResponseEntity<List<List<BitcoinHistorical>>> listAllLastDayBitcoinHistoricals() {
//		List<List<BitcoinHistorical>> bitcoins = bitcoinHistoricalService.listAllLastDayBitcoinHistoricals();
//		if (bitcoins.isEmpty()) {
//			 return new ResponseEntity<List<List<BitcoinHistorical>>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<List<BitcoinHistorical>>>(bitcoins,HttpStatus.OK);
//	}

	@GetMapping("/lastWeek")
	public ResponseEntity<List<BitcoinHistorical>> listAllLastWeekBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAllLastWeekBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastMonth")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastMonthBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAlllastMonthBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@GetMapping("/lastYear")
	public ResponseEntity<List<BitcoinHistorical>> listAlllastYearBitcoinHistoricals() {
		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAlllastYearBitcoinHistoricals();
		if (bitcoins.isEmpty()) {
			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BitcoinHistorical>>(bitcoins, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BitcoinHistorical> insertBitcoinHistorical(@Valid @RequestBody final BitcoinHistorical bitcoin) {
		bitcoinHistoricalService.insertBitcoinHistorical(bitcoin);
		return new ResponseEntity<BitcoinHistorical>(bitcoin, HttpStatus.CREATED);
	}
	
	@GetMapping("/lastExcangeValueForProviderAndCurrency/{cryptoexchangevaluesproviderId}/{currencyRegistryId}")
	public ResponseEntity<BitcoinHistoricalCustom> lastExcangeValueForProviderAndCurrency(
			@PathVariable("cryptoexchangevaluesproviderId") final long cryptoexchangevaluesproviderId,
			@PathVariable("currencyRegistryId") final long currencyRegistryId
			) {
		
		
		BitcoinHistoricalCustom toReturn = bitcoinHistoricalService.getLastExcangeByProviderIdAndCurrencyId(cryptoexchangevaluesproviderId, currencyRegistryId);
//		List<BitcoinHistorical> bitcoins = bitcoinHistoricalService.listAlllastYearBitcoinHistoricals();
//		if (bitcoins.isEmpty()) {
//			 return new ResponseEntity<List<BitcoinHistorical>>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<BitcoinHistoricalCustom>(toReturn, HttpStatus.OK);
	}
}
