package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ArtisthomeController {
    private final ArtisthomeService artisthomeService;

    @GetMapping("/artist")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {

        System.out.println("아티스트홈 컨트롤러 진입");

        mv.setViewName("artisthome/artisthome");

        String artistid = req.getParameter("artist_id_num");

        int artist_id = Integer.parseInt(artistid);

        System.out.println(artist_id);

        Artist artistinfo = artisthomeService.getartistinfobyid(artist_id);

        mv.addObject("artistinfo", artistinfo);

        return mv;

    }

    @GetMapping("/artist/id")
    public Artist getArtistbyid(ModelAndView mv, HttpServletRequest req) {

        String artistid = req.getParameter("artist_id_num");
        int artist_id = Integer.parseInt(artistid);

        Artist artistinfo = artisthomeService.getartistinfobyid(artist_id);

        return artistinfo;

    }

    @GetMapping("/artist/comment/{artist_id}") //artist_id에 대한 comment 읽기
    public List<Comment> getComment(@PathVariable int artist_id){
        List<Comment> commentList = artisthomeService.getArtistComment(artist_id);

        return commentList;
    }

    @PostMapping("/artist/comment") //전체 comment 읽기
    public void createComment(@RequestBody Comment comment){
        artisthomeService.createComment(comment);
    }

    @PutMapping("/artist/comment")
    public void modifyComment(@RequestBody Comment comment) {
        artisthomeService.modifyComment(comment);
    }

    @DeleteMapping("/artist/comment/{id}")
    ResponseEntity<String> deleteComment(@PathVariable int id) {
        artisthomeService.deleteComment(id);
        return ResponseEntity.ok("Comment with ID " + id + " 댓글이 삭제되었습니다");
    }
    //jwt 적용, 게시물 페이징


    //전체 게시물 대상 10개씩 페이징
    @GetMapping("/artistPage")
    public ResponseEntity<List<Artist>> list(int page, int pageSize, Model m, HttpServletRequest request) {
        Map map = new HashMap();
        // page = 3, pageSize =10 -> offset = 20 이므로
        // 21번째 게시물부터 10개를 출력
        map.put("offset", (page-1)*pageSize);
        map.put("pageSize", pageSize);
        List <Artist> list=artisthomeService.selectPage(map);

        m.addAttribute("list", list);

        return ResponseEntity.ok().body(list);
    }
}

// 제가 버전은 security 적용 X
// 지승님이 upstream에 security 적용한 버전을 올리신 상태
// pull