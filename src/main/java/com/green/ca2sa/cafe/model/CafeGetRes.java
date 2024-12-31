package com.green.ca2sa.cafe.model;

import com.green.ca2sa.common.PicUrlMaker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetRes {
    private long cafeId;
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private String openTime;
    private String closeTime;
}
