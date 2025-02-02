package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDelReq {
    @Schema(title = "유저 ID",example = "2",requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "비밀번호",example = "1111",requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
}
