package com.green.ca2sa.auth;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.auth.model.AuthCodeDto;
import com.green.ca2sa.auth.model.SendEmailAuthCodeReq;
import com.green.ca2sa.auth.model.VerifyEmailAuthCodeReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("email-auth")
@Tag(name = "이메일 인증")
public class AuthController {
    private final AuthService authService;
    private final AuthCodeService authCodeService;

    @PostMapping("send-code")
    @Operation(summary = "이메일 인증 코드 발송")
    public ResultResponse<Boolean> postSendCode(@Valid @RequestBody SendEmailAuthCodeReq p) {
        AuthCodeDto authCodeDto = authCodeService.generateAuthCode(p);
        boolean result = authService.sendCodeToEmail(p.getEmail(), "CA2SA 이메일 인증 코드 안내", authCodeDto);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("전송 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }

    @PostMapping("verify-code")
    @Operation(summary = "이메일 인증 코드 검사")
    public ResultResponse<Boolean> postVerifyCode(@Valid @RequestBody VerifyEmailAuthCodeReq p) {
        boolean result = authCodeService.validateAuthCode(p);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("인증 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }
}
