package com.aggroup.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aggroup.microservice.currencyconversionservice.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("currency-conversion/from/{fromCurrency}/to/{toCurrency}/{amount}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal amount) {
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
