package com.ants.currencyconversionservice.controller;


import com.ants.currencyconversionservice.repository.CurrencyConversionRepo;
import com.ants.currencyconversionservice.vo.ConversionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CurrencyConversionController {

    public static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyConversionRepo currencyConversionRepo;

    @PostMapping("/addConversion")
    public ConversionVO addConversionValue(@RequestBody ConversionVO conversionVO){
        ConversionVO cVO = currencyConversionRepo.save(conversionVO);
        logger.info("result:::::::::::::"+cVO);
        return cVO;
    }

    @GetMapping("/getConversion/{id}")
    public ConversionVO getConversionValueBasedOnId(@PathVariable int id){
        ConversionVO cVO = currencyConversionRepo.findById(id).get();
        logger.info("result:::::::::::::"+cVO);
        return cVO;
    }

    @GetMapping("/getConversionByname/{name}")
    public ConversionVO getConversionValueBasedOnName(@PathVariable String name){
        List<ConversionVO> cVOs = currencyConversionRepo.findAll();
        logger.info("result:::::::::::::"+cVOs);
        ConversionVO cVO=  cVOs.stream().filter(x->x.getCurrencyType().equals(name)).collect(Collectors.toList()).get(0);
        return cVO;
    }
}
