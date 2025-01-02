package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CafeGetOneRes {
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private String openTime;
    private String closeTime;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
