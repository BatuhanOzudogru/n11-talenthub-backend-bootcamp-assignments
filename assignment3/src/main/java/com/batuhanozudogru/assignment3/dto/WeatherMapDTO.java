package com.batuhanozudogru.assignment3.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class WeatherMapDTO implements Serializable {

    private static final long serialVersionUID = 1253320017739887653L;

    private String cod;

    private BigDecimal message;

    private Integer cnt;


    private List<WeatherMapTimeDTO> list;



}
