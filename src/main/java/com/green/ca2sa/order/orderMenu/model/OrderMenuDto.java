package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class OrderMenuDto {
    private long orderMenuId;
    private long menuId;
    private String orderMenuName;
    private int price;
    private int count;
    List<OrderMenuOptionDto> options;

}
