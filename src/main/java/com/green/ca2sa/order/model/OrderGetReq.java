package com.green.ca2sa.order.model;

import com.green.ca2sa.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderGetReq extends Paging {
    @Schema(title = "고객 유저 PK",name = "signed_user_id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long signedUserId;
    @Schema(title = "카페 관리자 PK",name = "cafe_admin_id")
    private Long cafeId;


    public OrderGetReq(Integer page, Integer size, @BindParam("signed_user_id")Long signedUserId
                                                  , @BindParam("cafe_admin_id")Long cafeId) {
        super(page, size);
        this.signedUserId = signedUserId;
        this.cafeId = cafeId;
    }
}

//orderId
    //userId cafeId 둘다 추가해놓고 integer null 체크해서 null이 아닐떄는 where문
 /*
    <if test="userId != null"> //만약 고객계정이면 이렇게
    where userId = #{userId}
        </if>

    <if test="cafeId != null"> // 카페계졍으로 조회할 시 이렇게
    where cafeId = #{cafeId}
        </if>


  */
