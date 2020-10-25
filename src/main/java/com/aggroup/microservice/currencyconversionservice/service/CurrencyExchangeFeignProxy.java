package com.aggroup.microservice.currencyconversionservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aggroup.microservice.currencyconversionservice.CurrencyConversionBean;

/**
 * This interface used to call the external API using feign
 * @author Mina
 *
 */
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignProxy {

	@GetMapping("currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency);

}
