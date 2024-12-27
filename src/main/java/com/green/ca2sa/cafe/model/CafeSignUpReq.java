package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CafeSignUpReq {
    private String cafeName;
    private String location;
    private String tel;
    private String closeTime;
    private String openTime;
    private String email;
    private String apw;
    private String businessNumber;
    private int agree;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @JsonIgnore
    private String cafePic;
    @JsonIgnore
    private long cafeId;
}
