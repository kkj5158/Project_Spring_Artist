package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import com.kafka.springboot.sys.artisthome.ArtisthomeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

}