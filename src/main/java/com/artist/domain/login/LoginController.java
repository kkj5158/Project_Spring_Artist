package com.artist.domain.login;

import com.artist.global.config.sec.jwt.JwtUtil;
import com.artist.model.dto.User;
import com.artist.model.dto.http.DefaultRes;
import com.artist.model.dto.http.ResponseMessage;
import com.artist.model.dto.http.StatusCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class LoginController {

    private final LoginService loginService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("")
    public ModelAndView login(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("login/login");

        return mv;
    }


    @PostMapping("/signup")
    public ResponseEntity<Void> register(@ModelAttribute User userdto, HttpServletRequest request) throws URISyntaxException {

        userdto.setPw(passwordEncoder.encode(userdto.getPw()));

        loginService.register(userdto);

        HttpHeaders headers = new HttpHeaders();

        URI location = new URI(request.getContextPath() + "/user");

        headers.setLocation(location);

        return new ResponseEntity<>(headers, HttpStatus.FOUND);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute User userdto, HttpServletResponse response, HttpServletRequest request) throws Exception {

        System.out.println("로그인 컨트롤러 진입");

        // 로그인 시도

        loginService.login(userdto);

        String jwt = jwtUtil.createToken(userdto.getUsername());
        response.addHeader("Authorization", "Bearer " + jwt);

        // 스프링 시큐리티 컨텍스트 홀더에 사용자 인증 정보 설정
        Authentication authentication = jwtUtil.createAuthentication(userdto.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        HttpHeaders headers = new HttpHeaders();

        URI location = new URI(request.getContextPath() + "/main");

        headers.setLocation(location);

        return new ResponseEntity<>(headers, HttpStatus.FOUND);


    }


}
