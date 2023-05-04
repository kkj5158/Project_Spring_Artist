package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArtisthomeServiceImpl implements ArtisthomeService {
    private  final ArtisthomeMapper artisthomeMapper;
    @Override
    public Artist getartistinfobyid(int artistid) {

        Artist artistinfo = artisthomeMapper.getArtistinfobyid(artistid);

        return artistinfo;
    }

    @Override
    public List<Artist> getAllArtistinfo() {
        List<Artist> artistList = artisthomeMapper.getAllArtistinfo();

        return artistList;
    }

    public List<Comment> getArtistComment(int artist_id) { //전체 comment 읽기
        List<Comment> commentList = artisthomeMapper.getArtistComment(artist_id);

        return commentList;
    }

    public void createComment(Comment comment) {
        artisthomeMapper.createComment(comment);
    }

    public void modifyComment(Comment comment) {
        artisthomeMapper.modifyComment(comment);
    }

    public void deleteComment(int id) {
        //Comment result = artisthomeMapper.getIdComment(id);
        artisthomeMapper.deleteComment(id);
        //return result;
    }

    public Comment getIdComment(int id) {
        return artisthomeMapper.getIdComment(id);
    }


    //페이징
    public List<Artist> selectPage(Map map) {
        return artisthomeMapper.findPage(map);
    }
}
