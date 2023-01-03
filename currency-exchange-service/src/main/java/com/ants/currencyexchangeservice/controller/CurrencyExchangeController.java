package com.ants.currencyexchangeservice.controller;


import com.ants.currencyexchangeservice.vo.ConversionVO;
import com.ants.currencyexchangeservice.vo.CurrencyExchangeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CurrencyExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getExchangeValue/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyExchangeVO getResult(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        Map<String,String> uriMap = new LinkedHashMap<>();
        uriMap.put("name",from);
        ResponseEntity<ConversionVO> conversionVO =  restTemplate.getForEntity("http://localhost:8084/getConversionByname/{name}", ConversionVO.class,uriMap);
        logger.info("conversionVO inside the controller:::::::::"+conversionVO.getBody());
        CurrencyExchangeVO currencyExchangeVO = new CurrencyExchangeVO();
        currencyExchangeVO.setFrom(from);
        currencyExchangeVO.setTo(to);
        currencyExchangeVO.setQuantity(quantity);
        currencyExchangeVO.setResult(conversionVO.getBody().getCurrencyValue()* quantity);

        logger.info("The conversion result is  :::::::::"+conversionVO.getBody().getCurrencyValue()* quantity);

        return currencyExchangeVO;
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
