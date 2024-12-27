package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CafePutReq {
    private String cafeName;
    private String location;
    private String tel;
    @JsonIgnore
    private String cafePic;
    private String closeTime;
    private String openTime;
    private long cafeId;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
