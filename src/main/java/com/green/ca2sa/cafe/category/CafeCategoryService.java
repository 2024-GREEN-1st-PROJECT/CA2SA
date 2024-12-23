package com.green.ca2sa.cafe.category;

import com.green.ca2sa.cafe.category.model.CafeCategoryGetReq;
import com.green.ca2sa.cafe.category.model.CafeCategoryGetRes;
import com.green.ca2sa.cafe.category.model.CafeCategoryPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeCategoryService {
    private final CafeCategoryMapper menuCategoryMapper;

    public int postCategory(CafeCategoryPostReq p) {
        return menuCategoryMapper.insCategory(p);
    }

    public List<CafeCategoryGetRes> getMenuCategory(CafeCategoryGetReq p) {
        return menuCategoryMapper.getMenuCategory(p);
    }
}
