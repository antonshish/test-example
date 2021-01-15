package com.example.currencyservice.feignclients;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GiphyServiceProxyTest {

    @Autowired
    GiphyServiceProxy giphyServiceProxy;

    @Test
    public void retrieveGif() {
        Assert.assertEquals("https://giphy.com/embed/hAcDHEhZHA2bu",
                giphyServiceProxy.retrieveGif("OMN8mvm50g82R8AnWn1xIle67WAbPMNc", "rich", "1","10")
                .getData()[0].getEmbed_url());
    }
}