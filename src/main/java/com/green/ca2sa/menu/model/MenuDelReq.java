package com.green.ca2sa.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuDelReq {
    @Positive
    @Schema(title = "메뉴 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuId;
    @Positive
    @Schema(title = "카페 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    @Schema(title = "카테고리 ID", example = "1")
    private long categoryId;
}