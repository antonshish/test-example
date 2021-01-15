package com.example.currencyservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-exchange")
public class ExchangeConfiguration {

    private String apikey;
    private String url;
    private String basecurrency;
    private String exchangecurrency;
    private String datepattern;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String uri) {
        this.url = url;
    }

    public String getBasecurrency() {
        return basecurrency;
    }

    public void setBasecurrency(String basecurrency) {
        this.basecurrency = basecurrency;
    }

    public String getExchangecurrency() {
        return exchangecurrency;
    }

    public void setExchangecurrency(String exchangecurrency) {
        this.exchangecurrency = exchangecurrency;
    }

    public String getDatepattern() {
        return datepattern;
    }

    public void setDatepattern(String datepattern) {
        this.datepattern = datepattern;
    }
}
