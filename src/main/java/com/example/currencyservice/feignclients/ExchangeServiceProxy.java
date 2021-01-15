package com.example.currencyservice.feignclients;

import com.example.currencyservice.configuration.ExchangeConfiguration;
import com.example.currencyservice.responsebeans.ExchangeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "name", url="${currency-exchange.url}")
public interface ExchangeServiceProxy {

    @GetMapping("/api/historical/{data}.json")
    public ExchangeBean retrieveExchangeRates(@PathVariable("data") String data,
                                              @RequestParam String app_id,
                                              @RequestParam String symbols
                                              );
}
