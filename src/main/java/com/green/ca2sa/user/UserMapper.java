package com.green.ca2sa.user;


import com.green.ca2sa.user.model.UserSpentReq;
import com.green.ca2sa.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUserSignUp(UserSignUpReq p);
    UserSignUpEmailCheckRes getUserEmailCheck(String email);
    UserSingInRes postUserSingIn(UserSignInReq p);
    int updateUserInfo(UserInfoPutReq p);
    int deleteUserInfo(UserInfoDelReq p);
    UserInfoDelDto deleteUpwCheck(UserInfoDelReq p);
    UserSpentRes selUserSpent(UserSpentReq p);

}
