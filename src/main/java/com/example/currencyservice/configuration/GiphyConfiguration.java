package com.example.currencyservice.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("giphy")
public class GiphyConfiguration {

    private String apikey;
    private String url;
    private String rich;
    private String broke;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRich() {
        return rich;
    }

    public void setRich(String rich) {
        this.rich = rich;
    }

    public String getBroke() {
        return broke;
    }

    public void setBroke(String broke) {
        this.broke = broke;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
