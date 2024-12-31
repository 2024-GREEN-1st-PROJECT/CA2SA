package com.green.ca2sa.common;

public class PicUrlMaker {
    public static String makePicUrl(long cafeId, String picName) {
        return String.format("/pic/cafe/%d/%s", cafeId, picName);
    }

    public static String makePicUrl(long cafeId, long menuId, String picName) {
        return String.format("/pic/cafe/%d/menu/%d/%s", cafeId, menuId, picName);
    }
}
