package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArtisthomeMapper {

    Artist getArtistinfobyid(int artistid);
    List<Artist> getAllArtistinfo();
    List<Comment> getAllComment();

}
