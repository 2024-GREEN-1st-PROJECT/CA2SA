package com.green.ca2sa.menu;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "메뉴 관리", description = "메뉴 등록, 메뉴 불러오기, 수정, 삭제")
@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService service;

    @PostMapping("cafe/menu")
    @Operation(summary = "Menu 등록하기")
    public ResultResponse<Integer> postMenuInfo(@RequestPart(required = false) MultipartFile pic, @RequestPart MenuPostReq p) {
        try {
            Integer result = service.postMenuInfo(pic, p);
            return ResultResponse.<Integer>builder()
                    .resultMessage("메뉴 등록 완료")
                    .resultData(result)
                    .build();
        } catch (IllegalArgumentException e) {
            return ResultResponse.<Integer>builder()
                    .resultMessage(e.getMessage())
                    .build();
        }
    }

    @GetMapping("menu")
    @Operation(summary = "Menu 가져오기")
    public ResultResponse< List<MenuGetRes>> getMenuInfo(@ParameterObject @ModelAttribute MenuGetReq p) {
        List<MenuGetRes> result = service.getMenuInfo(p);
        return ResultResponse.< List<MenuGetRes>>builder()
                .resultMessage("메뉴 출력 완료")
                .resultData(result)
                .build();
    }

    @GetMapping("menu/{menuId}")
    @Operation(summary = "Menu 상세 정보 불러오기")
    public ResultResponse<MenuDetailGetRes> getMenuDetailInfo(@PathVariable long menuId) {
        MenuDetailGetRes result = service.getMenuDetailInfo(menuId);
        return ResultResponse.<MenuDetailGetRes>builder()
                .resultMessage("메뉴 상세 정보 출력 완료")
                .resultData(result)
                .build();
    }

    @PutMapping("cafe/menu")
    @Operation(summary = "Menu 수정하기")
    public ResultResponse<Integer> updateMenuInfo(@RequestPart(required = false) MultipartFile pic, @Valid @RequestPart MenuPutReq p) {
        int result = service.updateMenuInfo(pic, p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping("cafe/menu")
    @Operation(summary = "Menu 삭제하기", description = "메뉴의 옵션 모두 삭제 처리")
    public ResultResponse<Integer> deleteMenuInfo(@Valid @ParameterObject @ModelAttribute MenuDelReq p) {
        Integer result = service.deleteMenuInfo(p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 삭제 완료")
                .resultData(result)
                .build();
    }


}