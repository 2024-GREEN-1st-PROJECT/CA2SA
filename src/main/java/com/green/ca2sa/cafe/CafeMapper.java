package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMapper {
    int updCafe(CafePutReq p);
    int insCafe(CafeSignUpReq p);
    List<CafeGetSalesDto> selSumPriceWeekOfDay(CafeGetSalesReq p);
    CafeGetOneRes selCafe(CafeGetOneReq p);
    List<CafeGetRes> selAllCafe(CafeGetReq p);
    List<CafeGetRes> searchCafe(CafeGetReq p);
}
