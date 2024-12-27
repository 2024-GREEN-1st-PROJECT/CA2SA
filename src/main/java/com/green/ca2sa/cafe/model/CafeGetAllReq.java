package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

@Getter
@Setter
public class CafeGetAllReq {
    @Schema(name = "user_latitude")
    private BigDecimal userLatitude;
    @Schema(name = "user_longitude")
    private BigDecimal userLongitude;
    @ConstructorProperties({"user_latitude","user_longitude"})
    public CafeGetAllReq(BigDecimal userLatitude, BigDecimal userLongitude) {
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }
}
