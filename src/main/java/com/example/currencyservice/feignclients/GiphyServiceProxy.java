package com.example.currencyservice.feignclients;

import com.example.currencyservice.responsebeans.GiphyBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "name1", url = "${giphy.url}")
public interface GiphyServiceProxy {

    @GetMapping("/v1/gifs/search")
    public GiphyBean retrieveGif(@RequestParam String api_key,
                                 @RequestParam String q,
                                 @RequestParam String limit,
                                 @RequestParam String offset);

}
