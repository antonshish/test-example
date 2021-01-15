package com.example.currencyservice.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GiphyConfigurationTest {

    @Autowired
    GiphyConfiguration giphyConfiguration;

    @Test
    public void getUrl() {

    }

    @Test
    public void getApikey() {
        assertEquals("OMN8mvm50g82R8AnWn1xIle67WAbPMNc", giphyConfiguration.getApikey());
    }
}