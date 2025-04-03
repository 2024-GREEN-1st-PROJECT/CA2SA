package com.green.ca2sa.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResultResponse<T> {
    @Schema(title = "결과 메시지 ")
    private String resultMessage;
    @Schema(title = "결과 내용")
    private T resultData;
}
