package com.green.ca2sa.user;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "회원 관리")

public class UserController {
    private final UserService service;


    @PostMapping("sign-up")
    @Operation(summary = "회원가입")
    public ResultResponse<Integer> postUserSignUp(@RequestBody UserSignUpReq p){
        int result=service.postUserSignUp(p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입완료")
                .resultData(result)
                .build();
    }

    @GetMapping("check-email")
    @Operation(summary = "이메일 중복 확인")
    public ResultResponse<Integer> getUserEmailCheck(@ParameterObject @ModelAttribute EmailCheckReq p){
        int result=service.getUserEmailCheck(p.getEmail());

        return ResultResponse.<Integer>builder()
                .resultData(result)
                .resultMessage(result==0?"존재하는 이메일 입니다":"이메일 인증해주세요")
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultResponse<UserSingInRes> postUserSignIn(@RequestBody UserSignInReq p){
        UserSingInRes res=service.postUserSingIn(p);


        return ResultResponse.<UserSingInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }



    @PutMapping("info")
    @Operation(summary = "회원정보 수정")
    public ResultResponse<Integer> updateUserInfo(@RequestBody UserInfoPutReq p){
        int result=service.updateUserInfo(p);

        return ResultResponse.<Integer>builder()
                .resultMessage(result==0?"비밀번호가 틀립니다":"회원정보수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "회원정보 삭제")
    public ResultResponse<Integer> deleteUserInfo(@RequestBody UserInfoDelReq p){
        int result=service.deleteUserInfo(p);

        return ResultResponse.<Integer>builder()
                .resultMessage(result==1?"회원정보 삭제 완료":"비밀번호가 틀립니다")
                .resultData(result)
                .build();

    }



}
