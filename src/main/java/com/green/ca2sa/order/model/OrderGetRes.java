package com.green.ca2sa.order.model;

import com.green.ca2sa.order.orderMenu.model.OrderMenuDto;
import lombok.*;

import java.util.List;

@Getter
@ToString
@Setter
public class OrderGetRes {
    private long orderId;
    private String nickName;
    private String cafeName;
    private long cafeId;
    private String location;
    private String pickUpTime;
    private String createdAt;
    private String memo;
    private int orderProgress;
    private List<OrderMenuDto> orderMenuList;

}
