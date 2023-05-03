package com.kafka.springboot.sys.login;

import com.kafka.springboot.http.ResponseMessage;
import com.kafka.springboot.http.StatusCode;
import com.kafka.springboot.sqlmap.model.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class LoginController {
    private final LoginService loginService ;

    @GetMapping("/")
    public ModelAndView login(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("login/login");

        return mv;
    }


    @PostMapping("/signup" )
    public ResponseEntity register(@RequestBody User userdto){

        System.out.println("회원가입 컨트롤러 진입");

        return loginService.register(userdto);


    }

    @PostMapping("/login" )
    public ResponseEntity login(@RequestBody User userdto, HttpServletResponse response){

        System.out.println("로그인 컨트롤러 진입");

        return loginService.login(userdto, response);



    }


}
