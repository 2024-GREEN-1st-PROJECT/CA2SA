package com.green.ca2sa.cafe.order.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeOrderPutReq {
    @Schema(title = "주문번호")
    private long orderId;
    @Schema(title = "주문상태 숫자로 0~4 0:주문확인, 1:준비중, 2:준비완료, 3: 수령완료, 4: 주문거절, 5: 주문 취소 요청, 6: 주문 취소 확인")
    private int orderProgress;
    @Schema(title = "유저의 id(사장)")
    private long userId;
}
