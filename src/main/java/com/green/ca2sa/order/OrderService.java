package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderCancelReq;
import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import com.green.ca2sa.order.orderMenu.OrderMenuMapper;
import com.green.ca2sa.order.orderMenu.OrderMenuOptionMapper;
import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionPostReq;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMenuMapper orderMenuMapper;
    private final OrderMenuOptionMapper orderMenuOptionMapper;

    @Transactional
    public int PostOrder(OrderPostReq p) {
        long startTime = System.currentTimeMillis();
        log.info("OrderPostReq:{}", p);
        int insOrderRes = orderMapper.insOrder(p);
        if (insOrderRes == 0) {
            log.error("insert order fail");
        }

        List<OrderMenuPostReq> menuList = p.getMenuList();
        menuList.forEach(item -> item.setOrderId(p.getOrderId()));

        int insOrderMenuRes = orderMenuMapper.insOrderMenu(menuList);
        if (insOrderMenuRes == 0) {
            log.error("insert order menu fail");
        }

        List<OrderMenuOptionPostReq> optionList = new ArrayList<>();
        long orderMenuId = menuList.get(0).getOrderMenuId();
        for (OrderMenuPostReq item : menuList) {
            for (OrderMenuOptionPostReq option : item.getOptions()) {
                option.setOrderMenuId(orderMenuId);
                optionList.add(option);
            }
            orderMenuId++;
        }

        int insOrderMenuOptionRes = orderMenuOptionMapper.insOrderMenuOption(optionList);
        if (insOrderMenuOptionRes == 0) {
            log.error("insert order menu option fail");
        }

        log.info("post order cost time:{}", System.currentTimeMillis() - startTime);

        return insOrderRes;
    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p) {
        if (p == null || p.getSignedUserId() == null) {
            return new ArrayList<>();
        }
        return orderMapper.getOrderList(p);
    }

    public int cancelOrder(OrderCancelReq p) {
        return orderMapper.cancelOrder(p);

    }
}




