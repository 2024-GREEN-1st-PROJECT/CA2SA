package com.green.ca2sa.cafe.menu;

import com.green.ca2sa.cafe.menu.model.CafeGetMenuReq;
import com.green.ca2sa.cafe.menu.model.CafeGetMenuRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMenuMapper {
    List<CafeGetMenuRes> selCafeMenu(CafeGetMenuReq p);
}
