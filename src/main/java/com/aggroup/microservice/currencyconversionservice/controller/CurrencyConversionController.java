package com.aggroup.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aggroup.microservice.currencyconversionservice.CurrencyConversionBean;
import com.aggroup.microservice.currencyconversionservice.service.CurrencyExchangeFeignProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeFeignProxy proxy;
	
	/**
	 * Use feign to call the other service in microservice project
	 * @param fromCurrency
	 * @param toCurrency
	 * @param amount
	 * @return
	 */
	@GetMapping("currency-conversion-feign/from/{fromCurrency}/to/{toCurrency}/{amount}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal amount) {
		
		CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(fromCurrency, toCurrency);
		if (currencyConversionBean.getRate() != null)
			currencyConversionBean.setAmount(amount);
		currencyConversionBean.setTotalCalculatedAmount(amount.multiply(currencyConversionBean.getRate()));
		return currencyConversionBean;
	}
	
	/**
	 * Old way to call web service by using RestTemplate but using feign is better in microservice projects
	 * @param fromCurrency
	 * @param toCurrency
	 * @param amount
	 * @return
	 */
	@GetMapping("currency-conversion/from/{fromCurrency}/to/{toCurrency}/{amount}")
	public CurrencyConversionBean retrieveExchangeValueWithOldWay(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal amount) {
		Map<String, String> uriParameters = new HashMap<>();
		uriParameters.put("fromCurrency", fromCurrency);
		uriParameters.put("toCurrency", toCurrency);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/currency-exchange/from/{fromCurrency}/to/{toCurrency}", CurrencyConversionBean.class, uriParameters);
		if (responseEntity.getBody().getRate() != null)
			responseEntity.getBody().setAmount(amount);
			responseEntity.getBody().setTotalCalculatedAmount(amount.multiply(responseEntity.getBody().getRate()));
		return responseEntity.getBody();
	}
}
