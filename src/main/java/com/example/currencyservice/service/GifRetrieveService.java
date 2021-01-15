package com.example.currencyservice.service;

import com.example.currencyservice.configuration.ExchangeConfiguration;
import com.example.currencyservice.configuration.GiphyConfiguration;
import com.example.currencyservice.feignclients.ExchangeServiceProxy;
import com.example.currencyservice.feignclients.GiphyServiceProxy;
import com.example.currencyservice.responsebeans.ExchangeBean;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@Component
public class GifRetrieveService {
    @Autowired
    private ExchangeServiceProxy exchangeServiceProxy;
    @Autowired
    private GiphyServiceProxy giphyServiceProxy;
    @Autowired
    GiphyConfiguration giphyConfiguration;
    @Autowired
    ExchangeConfiguration exchangeConfiguration;

    private String exchangeApiKey;
    private String exchangeCurrency;
    private String datePattern;

    private String giphyApiKey;

    private String rich = "rich";
    private String broke = "broke";

    @PostConstruct
    public void init() {
        exchangeApiKey = exchangeConfiguration.getApikey();
        exchangeCurrency = exchangeConfiguration.getExchangecurrency();
        datePattern = exchangeConfiguration.getDatepattern();

        giphyApiKey = giphyConfiguration.getApikey();
    }


    public String getGifUri() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        Calendar cal = Calendar.getInstance();
        String today = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, -1);
        String yesterday = dateFormat.format(cal.getTime());

        ExchangeBean exchangeBeanToday = null;
        ExchangeBean exchangeBeanYesterday;

        exchangeBeanToday = exchangeServiceProxy.retrieveExchangeRates(today, exchangeApiKey, exchangeCurrency);
        exchangeBeanYesterday = exchangeServiceProxy.retrieveExchangeRates(yesterday, exchangeApiKey, exchangeCurrency);


        BigDecimal todayExchangeRate = exchangeBeanToday.getRates().get(exchangeCurrency);
        BigDecimal yesterdayExchangeRate = exchangeBeanYesterday.getRates().get(exchangeCurrency);
        BigDecimal result = todayExchangeRate.subtract(yesterdayExchangeRate);

        Random random = new Random();
        if(result.compareTo(BigDecimal.ZERO) < 0) { // Если курс рубля упал, то курс доллара вырос
            return getRichGif(random);
        } else {
            return getBrokeGif(random);
        }
    }

    private String getGifUri(Random random, String status) {
        return giphyServiceProxy.retrieveGif(giphyApiKey, rich, "1",
                String.valueOf(random.nextInt(50))).getData()[0].getEmbed_url();
    }

    public String getRichGif(Random random) {
        return getGifUri(random, rich);
    }

    public String getBrokeGif(Random random) {
        return getGifUri(random, broke);
    }
}
