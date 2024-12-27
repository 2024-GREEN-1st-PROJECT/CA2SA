package com.green.ca2sa.user;

import com.green.ca2sa.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserMapper mapper;

    public int postUserSignUp(UserSignUpReq p){

        String hashPassword= BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setUpw(hashPassword);

        int result=mapper.postUserSignUp(p);

        return result;
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

    public UserInfoGetRes getUserInfo(long userId){
        UserInfoGetRes res=mapper.getUserInfo(userId);


        return res;

    }

    public int updateUserInfo(UserInfoPutReq p){

        UserInfoPutDto dto=mapper.updateCheckUpwInfo(p);

        if(!BCrypt.checkpw(p.getUpw(), dto.getUpw())){
            return 0; // 비밀번호가 틀릴시 0으로 리턴
        }



//        String hashedPassword=BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
//        p.setUpw(hashedPassword); 비밀번호는 수정못하는걸로 간다. 프론트에서 어렵다 함.


        int result=mapper.updateUserInfo(p);


        return result;
    }

    public int deleteUserInfo(long userId){

        int result=mapper.deleteUserInfo(userId);

        return result;
    }



    // 카페별 거리도 보내주기.
    public List<UserCafeInfoGetRes> getUserCafeInfo(UserLocationDto p){


        List<UserCafeInfoGetRes> result=mapper.getUserCafeInfo(p);




        return result;

    }


}
