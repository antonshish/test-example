package com.example.currencyservice.controller;


import com.example.currencyservice.configuration.ExchangeConfiguration;
import com.example.currencyservice.configuration.GiphyConfiguration;
import com.example.currencyservice.feignclients.ExchangeServiceProxy;
import com.example.currencyservice.feignclients.GiphyServiceProxy;
import com.example.currencyservice.responsebeans.ExchangeBean;
import com.example.currencyservice.service.GifRetrieveService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@RestController
public class MainController {

    @Autowired
    GifRetrieveService gifRetrieveService;


    @RequestMapping(value = "/currency-service", method = RequestMethod.GET)
    public String showGif(HttpServletResponse response) {
        String gifUri;
        try {
            gifUri = gifRetrieveService.getGifUri();
        } catch (FeignException e) {
            return "Данные о курсе валют за сегодняшний день пока недоступны";
        }

        try {
            response.sendRedirect(gifUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
