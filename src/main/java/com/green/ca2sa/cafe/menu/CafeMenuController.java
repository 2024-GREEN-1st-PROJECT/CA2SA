package com.green.ca2sa.cafe.menu;


import com.green.ca2sa.cafe.menu.model.CafeGetMenuReq;
import com.green.ca2sa.cafe.menu.model.CafeGetMenuRes;
import com.green.ca2sa.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cafe/menu")
@Tag(name = "카페 메뉴 조회")
public class CafeMenuController {
    private final CafeMenuService cafeMenuService;

    @GetMapping
    @Operation(summary = "카페 메뉴 조회")
    public ResultResponse<List<CafeGetMenuRes>> getCafeMenu(@ParameterObject CafeGetMenuReq p) {
        List<CafeGetMenuRes> res = cafeMenuService.selCafeMenu(p);
        return ResultResponse.<List<CafeGetMenuRes>>builder()
                .resultMessage("조회 완료")
                .resultData(res)
                .build();
    }

}
