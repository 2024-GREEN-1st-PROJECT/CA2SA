package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetSearchRes {
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private long cafeId;
    private int distance;
}
