package com.green.ca2sa.menu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDetailGetDto {
    private long menuOptionId;
    private String optionName;
    private int addPrice;
}
