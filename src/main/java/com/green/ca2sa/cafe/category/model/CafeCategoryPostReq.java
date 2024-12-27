package com.green.ca2sa.cafe.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeCategoryPostReq {
    @Schema(title = "카페 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    @Schema(title = "카테고리 이름", example = "커피", requiredMode = Schema.RequiredMode.REQUIRED)
    private String categoryName;
}