package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class CafeGetOneReq {
    @Schema(name="cafe_id")
    private long cafeId;
    public CafeGetOneReq(@BindParam("cafe_id") long cafeId) {
        this.cafeId = cafeId;
    }
}
