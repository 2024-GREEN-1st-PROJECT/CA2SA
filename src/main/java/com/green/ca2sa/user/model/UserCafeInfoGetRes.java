package com.green.ca2sa.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserCafeInfoGetRes {
    private long cafeId;
    private String cafeName;
    private String cafePic;
    private String location;
    private double distance;

    //위도 경도 받아서, service 에서 distance 계산만 할거라서 JsonIgnore 로 처리
    @JsonIgnore
    private BigDecimal latitude;
    @JsonIgnore
    private BigDecimal longitude;

}
