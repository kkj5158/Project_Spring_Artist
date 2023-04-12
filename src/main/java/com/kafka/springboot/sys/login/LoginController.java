package com.kafka.springboot.sys.login;

import com.kafka.springboot.sqlmap.model.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService ;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("login/login");

        return mv;
    }

    @PostMapping("/user" )
    public int register(@RequestBody User uservo){

        System.out.println("회원가입 컨트롤러 진입");

        int state = loginService.register(uservo);

        return state;

    }

}
