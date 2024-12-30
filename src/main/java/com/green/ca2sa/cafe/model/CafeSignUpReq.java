package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CafeSignUpReq {
    @Schema(title = "카페 이름", example = "카페051", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cafeName;
    @Schema(title = "카페 위치", example = "중파 만남의 장소", requiredMode = Schema.RequiredMode.REQUIRED)
    private String location;
    @Schema(title = "카페 연락처", example = "01066667444", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tel;
    @Schema(title = "오픈 시간", example = "21:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private String openTime;
    @Schema(title = "마감 시간", example = "21:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private String closeTime;
    @Schema(title = "카페 이메일", example = "green502@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(title = "관리자 비빌번호", example = "1717", requiredMode = Schema.RequiredMode.REQUIRED)
    private String apw;
    @Schema(title = "사업자번호", example = "12245678910", requiredMode = Schema.RequiredMode.REQUIRED)
    private String businessNumber;
    private int agree;
    @Schema(title = "유저 아이디")
    private long userId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @JsonIgnore
    private String cafePic;
    @JsonIgnore
    private long cafeId;
}
