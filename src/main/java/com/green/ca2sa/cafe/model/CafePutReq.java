package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CafePutReq {
    @Schema(title = "카페 이름", example = "카페051", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cafeName;
    @Schema(title = "카페 위치", example = "중파 만남의 장소", requiredMode = Schema.RequiredMode.REQUIRED)
    private String location;
    @Schema(title = "카페 연락처", example = "01066667444", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tel;
    @JsonIgnore
    private String cafePic;
    @Schema(title = "오픈 시간", example = "20:59", requiredMode = Schema.RequiredMode.REQUIRED)
    private String openTime;
    @Schema(title = "마감 시간", example = "21:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private String closeTime;
    @Schema(title = "카페 아아디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
