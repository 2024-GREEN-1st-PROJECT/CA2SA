package com.green.ca2sa.user;



import com.green.ca2sa.user.model.UserSpentReq;
import com.green.ca2sa.user.model.UserSpentRes;
import com.green.ca2sa.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserMapper mapper;

    public int postUserSignUp(UserSignUpReq p){

        String hashPassword= BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setUpw(hashPassword);

        return mapper.postUserSignUp(p);
    }

    public int getUserEmailCheck(String email){
        UserSignUpEmailCheckRes res=mapper.getUserEmailCheck(email);

        if(res==null){
            return 1;
        }

        return 0;

    }

    public UserSingInRes postUserSingIn(UserSignInReq p){
        UserSingInRes res=mapper.postUserSingIn(p);

        if(res==null){
            res=new UserSingInRes();
            res.setMessage("이메일을 확인해주세요");
            return res;
        }else if(!BCrypt.checkpw(p.getUpw(), res.getUpw())){
            res=new UserSingInRes();
            res.setMessage("비밀번호를 확인해주세요");
            return res;
        }

        res.setMessage("로그인 성공");

        return res;

    }



    public int updateUserInfo(UserInfoPutReq p){
        return mapper.updateUserInfo(p);
    }

    public int deleteUserInfo(UserInfoDelReq p){
        UserInfoDelDto dto=mapper.deleteUpwCheck(p); // 비밀번호 체크하기 위한 객체

        if(!BCrypt.checkpw(p.getUpw(), dto.getUpw())){
            return 0;
        }



        return mapper.deleteUserInfo(p);
    }

    public UserSpentRes selUserSpent(UserSpentReq p){
        return mapper.selUserSpent(p);
    }



}
