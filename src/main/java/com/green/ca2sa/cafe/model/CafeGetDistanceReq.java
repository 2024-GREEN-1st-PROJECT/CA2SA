package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

@Getter
@Setter
public class CafeGetDistanceReq {
    @Schema(name="cafe_id")
    private long cafeId;
    @Schema(name="user_latitude")
    private BigDecimal userLatitude;
    @Schema(name="user_longitude")
    private BigDecimal userLongitude;
    @ConstructorProperties({"cafe_id", "user_latitude", "user_longitude"})
    public CafeGetDistanceReq(long cafeId, BigDecimal userLatitude, BigDecimal longitude) {
        this.cafeId = cafeId;
        this.userLatitude = userLatitude;
        this.userLongitude = longitude;
    }
}
