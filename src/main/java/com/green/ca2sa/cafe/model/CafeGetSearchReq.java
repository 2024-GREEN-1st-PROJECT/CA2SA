package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

@Getter
@Setter
public class CafeGetSearchReq {
    @Schema(name = "search_location", description = "지역 카페이름 중 하나 입력")
    private String searchLocation;
    @Schema(name = "search_cafe_name", description = "지역 카페이름 중 하나 입력")
    private String searchCafeName;
    @Schema(name = "max_distance", defaultValue = "1000",description = "미기입시 1000m")
    private int maxDistance;
    @Schema(name = "user_latitude")
    private BigDecimal userLatitude;
    @Schema(name = "user_longitude")
    private BigDecimal userLongitude;
    @ConstructorProperties({"search_location", "search_cafe_name","max_distance", "user_latitude", "user_longitude"})
    public CafeGetSearchReq(String searchLocation, String searchCafeName, Integer maxDistance, BigDecimal userLatitude, BigDecimal userLongitude) {
        this.searchLocation = searchLocation;
        this.searchCafeName = searchCafeName;
        this.maxDistance = (maxDistance == null ? 1000 : maxDistance);
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }
}
