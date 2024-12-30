package com.green.ca2sa.cafe.menu;

import com.green.ca2sa.cafe.menu.model.CafeGetMenuReq;
import com.green.ca2sa.cafe.menu.model.CafeGetMenuRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeMenuService {
    private final CafeMenuMapper cafeMenuMapper;

    public List<CafeGetMenuRes> selCafeMenu(CafeGetMenuReq p){
        List<CafeGetMenuRes> res = cafeMenuMapper.selCafeMenu(p);

        return res;
    }

}
