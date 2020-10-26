package com.aggroup.microservice.currencyconversionservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aggroup.microservice.currencyconversionservice.CurrencyConversionBean;

/**
 * This interface used to call the external API using feign
 * 
 * @author Mina
 *
 */
//FeignClient = currency-exchange-service used if I need to call directly currency exchange service
//@FeignClient(name = "currency-exchange-service")
//FeignClient = zuul-api-gateway-server used if I need call currency exchange service through zuul API gateway
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignProxy {

	// Direct microservice call URL
	// @GetMapping("currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	// API Gateway URL
	@GetMapping("currency-exchange-service/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency,
			@PathVariable String toCurrency);

}
