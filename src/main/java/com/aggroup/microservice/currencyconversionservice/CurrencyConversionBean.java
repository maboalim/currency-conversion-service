package com.aggroup.microservice.currencyconversionservice;

import java.math.BigDecimal;

/**
 * Exchange Value bean which will be returned for exchange rate API
 * 
 * @author Mina
 *
 */
public class CurrencyConversionBean {

	private String fromCurrency;
	private String toCurrency;
	private BigDecimal amount;
	private BigDecimal rate;
	private BigDecimal totalCalculatedAmount;

	public CurrencyConversionBean() {

	}

	public CurrencyConversionBean(String fromCurrency, String toCurrency, BigDecimal amount,
			BigDecimal totalCalculatedAmount) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.amount = amount;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
