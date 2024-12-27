package com.green.ca2sa.user;

import com.green.ca2sa.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int postUserSignUp(UserSignUpReq p);
    UserSignUpEmailCheckRes getUserEmailCheck(String email);
    UserSingInRes postUserSingIn(UserSignInReq p);
    UserInfoGetRes getUserInfo(long userId);
    int updateUserInfo(UserInfoPutReq p);
    UserInfoPutDto updateCheckUpwInfo(UserInfoPutReq p);
    int deleteUserInfo(long userId);
    List<UserCafeInfoGetRes> getUserCafeInfo(UserLocationDto p);
}
