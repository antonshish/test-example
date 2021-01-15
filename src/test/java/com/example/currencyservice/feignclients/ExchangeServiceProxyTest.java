package com.example.currencyservice.feignclients;

import com.example.currencyservice.responsebeans.ExchangeBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeServiceProxyTest {

    @Autowired
    ExchangeServiceProxy exchangeServiceProxy;

    @Test
    public void retrieveExchangeRates() {

        Assert.assertEquals(BigDecimal.valueOf(73.15), exchangeServiceProxy
                .retrieveExchangeRates("2020-12-12", "b02c808ca5a24a6ea05f49ce1005bd6c","RUB").getRates().get("RUB"));
    }
}