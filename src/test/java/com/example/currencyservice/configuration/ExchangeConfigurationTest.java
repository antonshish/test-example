package com.example.currencyservice.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExchangeConfigurationTest {

    @Autowired
    private ExchangeConfiguration exchangeConfiguration;

    @Test
    public void getApikey() {
        assertEquals("b02c808ca5a24a6ea05f49ce1005bd6c", exchangeConfiguration.getApikey());
    }

    @Test
    public void getUrl() {
    }

    @Test
    public void getExchangecurrency() {
        assertEquals("RUB", exchangeConfiguration.getExchangecurrency());
    }

    @Test
    public void getDatepattern() {
        assertEquals("yyyy-MM-dd", exchangeConfiguration.getDatepattern());
    }
}