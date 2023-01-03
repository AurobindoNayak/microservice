package com.ants.currencyconversionservice.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
