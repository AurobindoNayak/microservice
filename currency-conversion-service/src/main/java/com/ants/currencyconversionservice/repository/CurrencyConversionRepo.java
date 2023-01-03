package com.ants.currencyconversionservice.repository;

import com.ants.currencyconversionservice.vo.ConversionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyConversionRepo extends JpaRepository<ConversionVO,Integer> {
}
