package com.green.ca2sa.menu.option;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import com.green.ca2sa.menu.option.model.MenuOptionPutReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "메뉴 옵션 관리", description = "메뉴 옵션 등록")
@RestController
@RequiredArgsConstructor
@RequestMapping("menu/option")
public class MenuOptionController {
    private final MenuOptionService service;

    @PostMapping
    @Operation(summary = "Menu 옵션 등록")
    public ResultResponse<Integer> postMenuOptionInfo(@RequestBody MenuOptionPostReq p) {
        Integer result = service.postMenuOptionInfo(p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 옵션 등록 완료")
                .resultData(result)
                .build();
    }

    @PutMapping
    @Operation(summary = "Menu 옵션 수정 완료")
    public ResultResponse<Integer> updateMenuOptionInfo(@RequestBody MenuOptionPutReq p) {
        Integer result = service.updateMenuOptionInfo(p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 옵션 수정 완료")
                .resultData(result)
                .build();
    }
}