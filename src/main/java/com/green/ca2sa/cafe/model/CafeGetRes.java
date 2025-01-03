package com.green.ca2sa.cafe.model;

import com.green.ca2sa.common.PicUrlMaker;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Getter
public class CafeGetRes {
    private long cafeId;
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private int distance;
    private String openTime;
    private String closeTime;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public CafeGetRes(long cafeId, String cafeName, String location, String tel, String pic, int distance, BigDecimal latitude, BigDecimal longitude, String openTime, String closeTime) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.location = location;
        this.tel = tel;
        this.distance = distance;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cafePic = PicUrlMaker.makePicUrl(cafeId, pic);
    }
}
