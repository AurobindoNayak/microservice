package com.ants.currencyexchangeservice.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConversionVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String currencyType;
    private double currencyValue;

}
