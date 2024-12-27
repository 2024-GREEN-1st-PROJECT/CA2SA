package com.green.ca2sa.user;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "회원 관리")

public class UserController {
    private final UserService service;
    private final Map<Long,UserLocationReq> userLocation = new HashMap<>(); // userId 의 위도,경도 객체 임시저장소로 설정

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

    @GetMapping("info")
    @Operation(summary = "회원정보 확인")
    public ResultResponse<UserInfoGetRes> getUserInfo(@RequestParam long userId){
        UserInfoGetRes res= service.getUserInfo(userId);

        return ResultResponse.<UserInfoGetRes>builder()
                .resultMessage(res==null?"회원정보가 없습니다":"회원 정보 조회 완료")
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
    public ResultResponse<Integer> deleteUserInfo(@RequestParam long userId){
        int result=service.deleteUserInfo(userId);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원정보 삭제 완료")
                .resultData(result)
                .build();

    }

    // 컨트롤러에서 자체적으로 처리하고 끝내는 메소드(postUserLocation)
    @PostMapping("location")
    @Operation(summary = "유저 위치 전송")
    public ResultResponse<Integer> postUserLocation(@RequestBody UserLocationReq p) {
        // 유저 ID를 하드코딩
        Long userId=p.getUserId();
        userLocation.put(userId, p); // 유저 ID를 키로 사용하여 위치 저장
        return ResultResponse.<Integer>builder()
                .resultMessage("유저 위치 정보 전송 완료")
                .resultData(1)
                .build();
    }


    @GetMapping
    @Operation(summary = "카페 정보 전체 출력")
    public ResultResponse<List<UserCafeInfoGetRes>> getUserCafeInfo(@RequestParam long userId) {

        UserLocationReq req=userLocation.get(userId);

        UserLocationDto dto=new UserLocationDto();

        dto.setUserLatitude(req.getUserLatitude());
        dto.setUserLongitude(req.getUserLongitude());


        List<UserCafeInfoGetRes> result = service.getUserCafeInfo(dto);


        return ResultResponse.<List<UserCafeInfoGetRes>>builder()
                .resultMessage("카페 정보 출력 완료")
                .resultData(result)
                .build();

    }

}
