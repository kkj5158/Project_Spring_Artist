package com.artist.domain.artisthome;

import com.artist.model.dto.Artist;
import com.artist.model.dto.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

//
//     * 게시글 리스트 조회
//     * @return 게시글 리스트
    List<Artist> findPage(Map map);


}
