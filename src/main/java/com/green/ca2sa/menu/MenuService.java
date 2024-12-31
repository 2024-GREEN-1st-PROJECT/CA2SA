package com.green.ca2sa.menu;

import com.green.ca2sa.cafe.category.CafeCategoryMapper;
import com.green.ca2sa.common.MyFileUtils;
import com.green.ca2sa.menu.model.*;
import com.green.ca2sa.menu.option.MenuOptionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuMapper mapper;
    private final MenuOptionMapper optionMapper;
    private final MyFileUtils myFileUtils;

    @Transactional
    public int postMenuInfo(MultipartFile pic, MenuPostReq p) {

        // 사진 null 체크
        if (pic == null) {
            return mapper.postMenuInfo(p);
        }
        //메뉴 사진 req 객체에 넣기
        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);

        int exists = mapper.existsMenu(p.getCafeId(), p.getMenuName());
        if (exists > 0) {
            throw new IllegalArgumentException("이미 존재하는 메뉴입니다.");
        }

        int result = mapper.postMenuInfo(p);
        long menuId = p.getMenuId();
        long cafeId = p.getCafeId();

        String middlePath = String.format("cafe/%d/menu/%d",cafeId, menuId); // 폴더 위치 수정했음
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public  List<MenuGetRes> getMenuInfo(MenuGetReq p) {
        // 데이터 조회
        List<MenuGetDto> list = mapper.getMenuInfo(p);

        // 카테고리별로 메뉴를 그룹화
        Map<String, List<MenuGetDto>> groupedByCategory = new HashMap<>();

        for (MenuGetDto dto : list) {
            groupedByCategory
                    .computeIfAbsent(dto.getCategoryName(), k -> new ArrayList<>())
                    .add(dto);
        }

        // 결과 데이터 생성
        List<MenuGetRes> res = new ArrayList<>();

        for (Map.Entry<String, List<MenuGetDto>> entry : groupedByCategory.entrySet()) {
            MenuGetRes resDto = new MenuGetRes();
            resDto.setCategoryName(entry.getKey());
            resDto.setMenu(entry.getValue()); // 메뉴 리스트 추가
            res.add(resDto);
        }

        return res;








//        List<MenuGetDto> list=mapper.getMenuInfo(p);
//
//        List<MenuGetRes> res= new ArrayList<>();
//
//
//        for(MenuGetDto dto:list){
//            MenuGetRes resDto=new MenuGetRes();
//            resDto.setCategoryName(dto.getCategoryName());
//            resDto.getMenu().add(dto);
//            res.add(resDto);
//        }
//
//        return res;



//        List<Map<String,Object>> result=new ArrayList<>();
//
//        Map<String,Object> map=new HashMap<>();
//
//        for(MenuGetDto dto:list){
//            map.put("category",dto.getCategoryName());
//
//            MenuGetDto2 dto2=new MenuGetDto2();
//            dto2.setMenuId(dto.getMenuId());
//            dto2.setMenuName(dto.getMenuName());
//            dto2.setMenuPic(dto.getMenuPic());
//            dto2.setPrice(dto.getPrice());
//
//            map.put("menu",dto2);

    }

    @Transactional
    public int updateMenuInfo(MultipartFile pic, MenuPutReq p) {

        if (pic == null) {
            return mapper.updateMenuInfo(p);
        }
        String deletePath = String.format("/menu/%d", p.getCafeId());
        myFileUtils.deleteFolder(deletePath, true);

        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);

        int result = mapper.updateMenuInfo(p);

        long menuId = p.getMenuId();
        String middlePath = String.format("/menu/%d/%d", p.getCategoryId(),menuId);
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Transactional
    public int deleteMenuInfo(MenuDelReq p) {

        String deletePath = String.format("cafe/%d/menu/%d/%d", p.getCafeId(), p.getCategoryId(), p.getMenuId());
        myFileUtils.deleteFolder(deletePath, true);

        return mapper.deleteMenuInfo(p);
    }

    @Transactional
    public MenuDetailGetRes getMenuDetailInfo(MenuDetailGetReq p) {

        List<MenuDetailGetDto> detailList=mapper.getMenuDetailInfo(p);

        MenuDetailGetRes detailGetRes= mapper.getMenuDetail(p);

        detailGetRes.setDetailList(detailList);

        return detailGetRes;

    }
}