package com.green.ca2sa.menu.option.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuOptionPutReq {
    private long menuOptionId;
    @Schema(title = "옵션 이름", example = "아이스", requiredMode = Schema.RequiredMode.REQUIRED)
    private String optionName;
    @Schema(title = "옵션 가격", example = "500", requiredMode = Schema.RequiredMode.REQUIRED)
    private int addPrice;
}