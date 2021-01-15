package com.example.currencyservice.controller;

import com.example.currencyservice.feignclients.ExchangeServiceProxy;
import com.example.currencyservice.feignclients.GiphyServiceProxy;
import com.example.currencyservice.responsebeans.ExchangeBean;
import com.example.currencyservice.responsebeans.GiphyBean;
import com.example.currencyservice.service.GifRetrieveService;
import feign.FeignException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private GifRetrieveService gifRetrieveService;

    @MockBean
    private ExchangeServiceProxy exchangeServiceProxy;
    @MockBean
    private GiphyServiceProxy giphyServiceProxy;


    @Test
    public void getGif() throws Exception {
        ExchangeBean mockExchangeBeanToday = new ExchangeBean();
        ExchangeBean mockExchangeBeanYesterday = new ExchangeBean();
        Map<String, BigDecimal> todayRates = new HashMap<>();
        todayRates.put("RUB", BigDecimal.valueOf(10L));
        Map<String, BigDecimal> yesterdayRates = new HashMap<>();
        yesterdayRates.put("RUB", BigDecimal.valueOf(5L));
        mockExchangeBeanToday.setRates(todayRates);
        mockExchangeBeanYesterday.setRates(yesterdayRates);
        when(exchangeServiceProxy.retrieveExchangeRates(anyString(), anyString(), anyString()))
                .thenReturn(mockExchangeBeanToday).thenReturn(mockExchangeBeanYesterday);

        GiphyBean mockGiphyBean = new GiphyBean(new GiphyBean.Data[]{new GiphyBean.Data("https://giphy.com/embed/79EfR7TtDmkq4")});
        when(giphyServiceProxy.retrieveGif(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(mockGiphyBean);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency-service");
        mockMvc.perform(requestBuilder).andExpect(status().is(302)).andReturn();
    }

}