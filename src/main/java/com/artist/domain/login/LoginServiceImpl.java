package com.artist.domain.login;

import com.artist.model.dto.http.ResponseMessage;
import com.artist.model.dto.http.StatusCode;
import com.artist.global.config.sec.jwt.JwtUtil;
import com.artist.model.dto.http.DefaultRes;
import com.artist.model.dto.User;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginMapper loginMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;
    @Override
    public void register(User user) {

        System.out.println("서비스 진입");

        if(loginMapper.getIdcnt(user) > 0){
            throw new IllegalArgumentException("중복 아이디가 이미 존재합니다.");
        }
        else if(loginMapper.getEmailcnt(user) > 0){
            throw new IllegalArgumentException("중복 이메일이 이미 존재합니다.");
        }
        else{
            loginMapper.insertuser(user);
            return;
        }
    }

    @Override
    public void login(User user, HttpServletResponse response) {

        User userdao = loginMapper.getUserbyusername(user.getUsername());

        if(userdao == null){

            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");

        }
        else{
            if(passwordEncoder.matches(user.getPw(), userdao.getPw())){

                response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername()));

                return;

            }
            else{

                throw new IllegalArgumentException("비밀번호가 불일치 합니다");

            }

        }


    }


}
