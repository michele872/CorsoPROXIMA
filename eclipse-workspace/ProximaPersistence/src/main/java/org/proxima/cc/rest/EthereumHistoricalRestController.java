package org.proxima.cc.rest;

import java.util.List;
import javax.validation.Valid;

import org.proxima.cc.entities.ethereum.EthereumHistorical;
import org.proxima.cc.entities.ethereum.EthereumHistoricalCustom;

import org.proxima.cc.services.EthereumHistoricalService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ethereum")
public class EthereumHistoricalRestController {
	public static final Logger logger = LoggerFactory.getLogger(EthereumHistoricalRestController.class);

    @Autowired
    EthereumHistoricalService ethereumHistoricalService;
	
	@GetMapping("/")
	public ResponseEntity<List<EthereumHistorical>> listAllEthereumHistoricals() {
		List<EthereumHistorical> ethereums = ethereumHistoricalService.listAllEthereumHistoricals();
		if (ethereums.isEmpty()) {
			 return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay")
	public ResponseEntity<List<EthereumHistorical>> listAllLastDayEthereumHistoricals() {
		List<EthereumHistorical> ethereums = ethereumHistoricalService.listAllLastDayEthereumHistoricals();
		if (ethereums.isEmpty()) {
			 return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@GetMapping("/lastDay/{cryptoexchangevaluesproviderid}")
	public ResponseEntity<List<EthereumHistorical>> listAllLastDayEthereumHistoricals(
			@PathVariable("cryptoexchangevaluesproviderid") final long cryptoexchangevaluesproviderId) {
		List<EthereumHistorical> ethereums = ethereumHistoricalService
				.listAllLastDayEthereumHistoricals(cryptoexchangevaluesproviderId);
		if (ethereums.isEmpty()) {
			return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@GetMapping("/lastWeek")
	public ResponseEntity<List<EthereumHistorical>> listAllLastWeekEthereumHistoricals() {
		List<EthereumHistorical> ethereums = ethereumHistoricalService.listAllLastWeekEthereumHistoricals();
		if (ethereums.isEmpty()) {
			 return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@GetMapping("/lastMonth")
	public ResponseEntity<List<EthereumHistorical>> listAlllastMonthEthereumHistoricals() {
		List<EthereumHistorical> ethereums = ethereumHistoricalService.listAlllastMonthEthereumHistoricals();
		if (ethereums.isEmpty()) {
			 return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@GetMapping("/lastYear")
	public ResponseEntity<List<EthereumHistorical>> listAlllastYearEthereumHistoricals() {
		List<EthereumHistorical> ethereums = ethereumHistoricalService.listAlllastYearEthereumHistoricals();
		if (ethereums.isEmpty()) {
			 return new ResponseEntity<List<EthereumHistorical>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EthereumHistorical>>(ethereums, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EthereumHistorical> insertEthereumHistorical(@Valid @RequestBody final EthereumHistorical ethereum) {
		ethereumHistoricalService.insertEthereumHistorical(ethereum);
		return new ResponseEntity<EthereumHistorical>(ethereum, HttpStatus.CREATED);
	}
	
	@GetMapping("/lastvalue/{cryptoexchangevaluesproviderId}/{currencyRegistryId}")
	public ResponseEntity<EthereumHistoricalCustom> lastExcangeValueForProviderAndCurrency(
			@PathVariable("cryptoexchangevaluesproviderId") final long cryptoexchangevaluesproviderId,
			@PathVariable("currencyRegistryId") final long currencyRegistryId) {
		EthereumHistoricalCustom toReturn = ethereumHistoricalService.getLastExcangeByProviderIdAndCurrencyId(cryptoexchangevaluesproviderId, currencyRegistryId);
		if (toReturn == null) {

			return new ResponseEntity<EthereumHistoricalCustom>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<EthereumHistoricalCustom>(toReturn, HttpStatus.OK);
	}

	

	@GetMapping("/lastvalues/{currencyRegistryId}")
	public ResponseEntity<List<EthereumHistoricalCustom>> lastExchangeValuesForCurrency(
			@PathVariable("currencyRegistryId") final long currencyRegistryId) {
		
		System.out.println("inizio");
		List<EthereumHistoricalCustom> toReturn = ethereumHistoricalService.getLastExchangeValuesByCurrencyId(currencyRegistryId);
		
		if (toReturn == null) {

			return new ResponseEntity<List<EthereumHistoricalCustom>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<EthereumHistoricalCustom>>(toReturn, HttpStatus.OK);
	}
}
