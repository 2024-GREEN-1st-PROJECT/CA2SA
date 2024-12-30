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
import java.util.concurrent.atomic.AtomicLong;

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
        int result = orderMapper.insOrder(p);
        // xml 에 foreach 문 사용해서 올리기
        List<OrderMenuPostReq> menuList = p.getMenuList().stream()
                .peek(item -> item.setOrderId(p.getOrderId())) //오더 아이디 다 집어 넣어주는거 그냥 for문 돌리면서 값 넣어주는거로 보면 된다
                .toList();

        int result2 = orderMenuMapper.insOrderMenu(menuList);
        //db에 넣는용도로 만든 변수. 단순 데이터 저장

        AtomicLong orderMenuId = new AtomicLong(menuList.get(0).getOrderMenuId());
        List<OrderMenuOptionPostReq> optionList = menuList.stream()
                .flatMap(item -> {
                    long currentOrderMenuId = orderMenuId.getAndIncrement(); // 현재 메뉴에 고유 ID 설정
                    item.getOptions().forEach(option -> option.setOrderMenuId(currentOrderMenuId)); // 옵션에 ID 설정
                    return item.getOptions().stream(); // 옵션 스트림 반환
                })
                .toList();
//        List<OrderMenuOptionPostReq> optionList = new LinkedList<>();
//        long orderMenuId = menuList.get(0).getOrderMenuId();
//        for (OrderMenuPostReq item : p.getMenuList()) {
//            for (OrderMenuOptionPostReq option : item.getOptions()) { // 옵션
//                option.setOrderMenuId(orderMenuId); // 오더 메뉴아이디 받거 세팅하고
//                optionList.add(option); // 옵션을 추가한다
//            }
//            orderMenuId++;   //그리고 메뉴 추가
//        }
        int result3 = orderMenuOptionMapper.insOrderMenuOption(optionList);
        //db에 넣는용도로 만든 변수. 단순 데이터 저장
        log.info("post order cost time:{}", System.currentTimeMillis() - startTime);
        return result;
    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p) {

        return orderMapper.getOrderList(p);
    }

    public int cancelOrder(OrderCancelReq p){
        return orderMapper.cancelOrder(p);

    }
}




