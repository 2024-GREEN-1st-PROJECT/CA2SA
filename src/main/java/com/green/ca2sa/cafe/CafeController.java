package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import com.green.ca2sa.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
@Slf4j
@Tag(name = "카페 관련")
public class CafeController {
    private final CafeService cafeService;


    @PostMapping("sign-up")
    @Operation(summary = "카페 회원가입(postman으로 해야됨)")
    public ResultResponse<Integer> cafeSignUp(@RequestPart(required = false)MultipartFile pic,
                                              @RequestPart CafeSignUpReq p) {
        int res = cafeService.signUpCafe(pic,p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입 완료")
                .resultData(res)
                .build();
    }
    @GetMapping("/{cafeId}")
    @Operation(summary = "카페 정보 조회")
    public ResultResponse<CafeGetOneRes> getCafe(@ParameterObject @ModelAttribute CafeGetOneReq p) {
        CafeGetOneRes res = cafeService.selCafe(p);
        return ResultResponse.<CafeGetOneRes>builder()
                .resultData(res)
                .resultMessage("카페 정보 조회 완료")
                .build();
    }
    @GetMapping("sales")
    @Operation(summary = "카페 판매액 조회")
    public ResultResponse<CafeGetSalesRes> getCafeSales(@ParameterObject @ModelAttribute CafeGetSalesReq p) {
        CafeGetSalesRes res = cafeService.selCafeSales(p);
        return ResultResponse.<CafeGetSalesRes>builder()
                .resultData(res)
                .resultMessage("조회 완료")
                .build();
    }

    @GetMapping
    @Operation(summary = "여러 카페 조회")
    public ResultResponse<List<CafeGetRes>> getCafeSearch(@ParameterObject @ModelAttribute CafeGetReq p) {
        List<CafeGetRes> res = cafeService.selSearchCafe(p);
        return ResultResponse.<List<CafeGetRes>>builder()
                .resultData(res)
                .resultMessage("조회 완료")
                .build();
    }


    @PutMapping
    @Operation(summary = "카페 정보 수정")
    public ResultResponse<Integer> patchCafe(@RequestPart(required = false) MultipartFile pic,
                                             @RequestPart CafePutReq p){
        log.info("p 값 {}",p);
        int result = cafeService.updCafe(pic,p);
        return ResultResponse.<Integer>builder()
                .resultData(result)
                .resultMessage(result == 0 ? "카페정보 수정 실패" : "카페정보 수정 완료")
                .build();
    }

}
