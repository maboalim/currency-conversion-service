package com.aggroup.microservice.currencyconversionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aggroup.microservice.currencyconversionservice.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service", url = "localhost:8080")
public interface CurrencyExchangeFeignProxy {

	@GetMapping("currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency);

}
