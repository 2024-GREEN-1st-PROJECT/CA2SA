package com.green.ca2sa.menu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuDetailGetRes {
    private String menuName;
    private int price;
    private String comment;
    private String menuPic;
    private List<MenuDetailGetDto> detailList;
}
