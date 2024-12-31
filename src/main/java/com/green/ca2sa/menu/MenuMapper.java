package com.green.ca2sa.menu;

import com.green.ca2sa.menu.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int postMenuInfo(MenuPostReq p);
    int existsMenu(long cafeId, String menuName);
    List<MenuGetDto> getMenuInfo(MenuGetReq p);
    int updateMenuInfo(MenuPutReq p);
    int deleteMenuInfo(MenuDelReq p);
    MenuDetailGetRes getMenuDetail(long menuId);
}
