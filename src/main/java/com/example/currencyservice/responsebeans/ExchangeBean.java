package com.example.currencyservice.responsebeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.lang.annotation.RequiredTypes;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeBean {

    private Map<String, BigDecimal> rates;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
