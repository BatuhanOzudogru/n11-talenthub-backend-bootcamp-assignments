package com.batuhanozudogru.assignment3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
@Getter
@Setter
public class WeatherAverageDTO implements Serializable {

    private static final long serialVersionUID = 5763148931413501367L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private BigDecimal daily;

    private BigDecimal nightly;

    private BigDecimal pressure;

    @JsonIgnore
    private BigDecimal totalDaily;

    @JsonIgnore
    private Integer quantDaily;

    @JsonIgnore
    private BigDecimal totalNightly;

    @JsonIgnore
    private Integer quantNightly;

    @JsonIgnore
    private BigDecimal totalPressure;

    @JsonIgnore
    private Integer quantPressure;

    public WeatherAverageDTO() {
        this.totalDaily = BigDecimal.ZERO;
        this.totalNightly = BigDecimal.ZERO;
        this.totalPressure = BigDecimal.ZERO;
        this.quantDaily = 0;
        this.quantNightly = 0;
        this.quantPressure = 0;
    }

    public WeatherAverageDTO(LocalDate date, BigDecimal daily, BigDecimal nightly, BigDecimal pressure,
                             BigDecimal totalDaily, Integer quantDaily, BigDecimal totalNightly, Integer quantNightly,
                             BigDecimal totalPressure, Integer quantPressure) {
        this.date = date;
        this.daily = daily;
        this.nightly = nightly;
        this.pressure = pressure;
        this.totalDaily = totalDaily;
        this.quantDaily = quantDaily;
        this.totalNightly = totalNightly;
        this.quantNightly = quantNightly;
        this.totalPressure = totalPressure;
        this.quantPressure = quantPressure;
    }

    public void plusMap(WeatherMapTimeDTO map) {
        if (map.isDaily()) {
            this.totalDaily = this.totalDaily.add(map.getMain().getTemp());
            this.quantDaily++;
        } else {
            this.totalNightly = this.totalNightly.add(map.getMain().getTemp());
            this.quantNightly++;
        }
        this.totalPressure = this.totalPressure.add(map.getMain().getTemp());
        this.quantPressure++;
    }

    public void totalize() {
        this.daily = (this.quantDaily > 0)
                ? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.nightly = (this.quantNightly > 0)
                ? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
                : null;
        this.pressure = (this.quantPressure > 0)
                ? this.totalPressure.divide(new BigDecimal(this.quantPressure.toString()), 2, RoundingMode.HALF_UP)
                : null;
    }


}
