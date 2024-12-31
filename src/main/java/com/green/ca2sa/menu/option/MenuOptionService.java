package com.green.ca2sa.menu.option;

import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import com.green.ca2sa.menu.option.model.MenuOptionPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuOptionService {
    private final MenuOptionMapper mapper;

    public int postMenuOptionInfo(MenuOptionPostReq p) {
        int result = mapper.postMenuOptionInfo(p);
        p.getMenuOptionId();
        int exists = mapper.existsMenuOption(p.getMenuId(), p.getOptionName());
        if (exists > 0) {
            throw new IllegalArgumentException("이미 존재하는 옵션입니다.");
        }
        return result;
    }

    public int updateMenuOptionInfo(MenuOptionPutReq p) {
        int result = mapper.updateMenuOptionInfo(p);
        p.getMenuOptionId();
        return result;
    }
}