package com.green.ca2sa.menu.option;

import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import com.green.ca2sa.menu.option.model.MenuOptionPutReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuOptionMapper {
    int postMenuOptionInfo(MenuOptionPostReq p);
    int updateMenuOptionInfo(MenuOptionPutReq p);
}