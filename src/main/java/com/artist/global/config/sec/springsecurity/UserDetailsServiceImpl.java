package com.artist.global.config.sec.springsecurity;


import com.artist.global.config.sec.jwt.JwtUtil;
import com.artist.model.dto.User;
import com.artist.domain.login.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LoginMapper loginMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("UserDetailsServiceImpl.loadUserByUsername : " + username);

        User userdao = loginMapper.getUserbyusername(username);

        if(userdao == null){

            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");

        }

        return new UserDetailsImpl(userdao, userdao.getUsername(), userdao.getPw());
    }

}
