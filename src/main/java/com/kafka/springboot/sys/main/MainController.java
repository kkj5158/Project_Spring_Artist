package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.artist;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MainService mainService;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {

        mv.setViewName("main/main");

        System.out.println("메인 컨트롤러 진입");

        List<artist> artistList = mainService.getAllArtistinfo();

        mv.addObject("artistList", artistList);

        return mv;

    }

}
