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
    public List<artist> main() {

        System.out.println("dfdfddd");
        return mainService.getAllArtistinfo();


    }

}
