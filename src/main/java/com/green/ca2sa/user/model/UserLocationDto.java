package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
// 위도,경도 계산하는 용도의 dto 객체
public class UserLocationDto {
    private BigDecimal userLatitude;
    private BigDecimal userLongitude;
}
