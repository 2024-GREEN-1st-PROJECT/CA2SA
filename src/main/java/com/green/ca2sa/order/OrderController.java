package com.green.ca2sa.order;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResultResponse<Integer> postOrder(OrderPostReq p) {
        int result = orderService.PostOrder(p);
        log.info("OrderController > postOrder > req: {}", p);
        return ResultResponse.<Integer>builder()
                .resultMessage("주문등록완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultResponse<List<OrderGetRes>> getOrderList(OrderGetReq p) {
        List<OrderGetRes> list = orderService.GetOrderList(p);
        return ResultResponse.<List<OrderGetRes>>builder()
                .resultMessage("오더 조회 완료")
                .resultData(list)
                .build();
    }
}
