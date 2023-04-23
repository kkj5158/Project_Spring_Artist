package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Comment> getAllComment() { //전체 comment 읽기
        List<Comment> commentList = artisthomeMapper.getAllComment();

        return commentList;
    }
}
