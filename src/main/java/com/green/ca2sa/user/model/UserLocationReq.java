package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserLocationReq { // 유저 위도,경도 정보를 프론트에서 받는 Req 객체
    @Schema(title = "유저 ID",example = "1",requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "유저 위도",example = "123.4624",requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal userLatitude;
    @Schema(title = "유저 경도",example = "123.4624",requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal userLongitude;
}
