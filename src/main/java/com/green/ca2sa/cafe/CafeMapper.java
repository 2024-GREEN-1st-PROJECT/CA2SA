package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMapper {
    int updCafe(CafePutReq p);
    CafeGetRes selCafe(long cafeId);
    String cafeEmailCheck(String email);
    int insCafe(CafeSignUpReq p);
    CafeSignInRes signInCafe(String email);
    List<CafeGetSalesDto> selSumPriceWeekOfDay(CafeGetSalesReq p);
}
