package com.kafka.springboot.sys.login;

import com.kafka.springboot.sqlmap.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginMapper loginMapper;
    @Override
    public int register(User user) {

        System.out.println("서비스 진입");

        int result;

        if(loginMapper.getId(user) > 0){
            result = -1;
            return result;
        }
        else if(loginMapper.getEmail(user) > 0){
            result = -2;
            return result;
        }
        else{
            result = loginMapper.insertuser(user);

            if(result==1){
                return result;
            }
            else{
                return -3;
            }
        }


    }


}
