package com.green.ca2sa.menu.option;

import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import com.green.ca2sa.menu.option.model.MenuOptionPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuOptionService {
    private final MenuOptionMapper mapper;

    @Transactional
    public int postMenuOptionInfo(MenuOptionPostReq p) {
        boolean exists = mapper.existsMenuOption(p.getMenuId(), p.getOptionName());
        if (exists) {
            throw new IllegalArgumentException("이미 존재하는 옵션입니다.");
        }
        return mapper.postMenuOptionInfo(p);
    }

    public int updateMenuOptionInfo(MenuOptionPutReq p) {
        int result = mapper.updateMenuOptionInfo(p);
        p.getMenuOptionId();
        return result;
    }
}