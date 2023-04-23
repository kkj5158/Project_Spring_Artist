package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArtisthomeMapper {

    Artist getArtistinfobyid(int artistid);
    List<Artist> getAllArtistinfo();
    List<Comment> getArtistComment(int artist_id);
    Comment getIdComment(int id);

    void createComment(Comment comment);
    void modifyComment(Comment comment);

    void deleteComment(int id);

}
