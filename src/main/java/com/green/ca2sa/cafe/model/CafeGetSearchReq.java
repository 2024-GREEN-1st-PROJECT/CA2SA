package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

@Getter
@Setter
public class CafeGetSearchReq {
    @Schema(name = "search_menu_name", description = "메뉴이름으로 검색")
    private String searchMenuName;
    @Schema(name = "search_cafe_name", description = "카페이름으로 검색")
    private String searchCafeName;
    @Schema(name = "max_distance", defaultValue = "1000",description = "미기입시 1000m")
    private int maxDistance;
    @Schema(name = "user_latitude")
    private BigDecimal userLatitude;
    @Schema(name = "user_longitude")
    private BigDecimal userLongitude;
    @ConstructorProperties({"search_menu_name", "search_cafe_name","max_distance", "user_latitude", "user_longitude"})
    public CafeGetSearchReq(String searchMenuName, String searchCafeName, Integer maxDistance, BigDecimal userLatitude, BigDecimal userLongitude) {
        this.searchMenuName = searchMenuName;
        this.searchCafeName = searchCafeName;
        this.maxDistance = (maxDistance == null ? 1000 : maxDistance);
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }
}
