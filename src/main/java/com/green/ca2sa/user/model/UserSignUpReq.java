package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title="유저 회원가입 요청")
public class UserSignUpReq {
    @Schema(title = "이메일",example = "yaho@gmail.com",requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(title = "비밀번호",example = "1111",requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "닉네임",example = "홍길동")
    private String nickName;

}
