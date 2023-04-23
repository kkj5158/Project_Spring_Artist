package com.kafka.springboot.sys.login;

import com.kafka.springboot.http.ResponseMessage;
import com.kafka.springboot.http.StatusCode;
import com.kafka.springboot.sec.jwt.JwtUtil;
import com.kafka.springboot.sqlmap.model.dto.DefaultRes;
import com.kafka.springboot.sqlmap.model.dto.User;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginMapper loginMapper;

    private final JwtUtil jwtUtil;
    @Override
    public ResponseEntity register(User user) {

        System.out.println("서비스 진입");

        int result;

        if(loginMapper.getIdcnt(user) > 0){
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.DUPULICATE_USER), HttpStatus.BAD_REQUEST);
        }
        else if(loginMapper.getEmailcnt(user) > 0){
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.DUPULICATE_EMAIL), HttpStatus.BAD_REQUEST);
        }
        else{
            result = loginMapper.insertuser(user);

            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED_USER), HttpStatus.OK);

        }


    }

    @Override
    public ResponseEntity login(User user, HttpServletResponse response) {

        User userdao = loginMapper.getUserbyid(user);

        if(userdao == null){
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL), HttpStatus.BAD_REQUEST);
        }
        else{
            if(userdao.getPw().equals(user.getPw())){

                response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUser_id()));

                return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS), HttpStatus.OK);

            }
            else{
                // 비밀번호 불일치
                return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL), HttpStatus.BAD_REQUEST);

            }

        }


    }


}
