package com.green.ca2sa.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuGetDto { // MenuGetRes 멤버필드 list 에 들어가는 객체
    private long menuId;
    private String menuName;
    private int price;
    private String comment;
    private String menuPic;
    @JsonIgnore
    private String categoryName;
}
