package com.artist.domain.artisthome;

import com.artist.model.dto.Artist;
import com.artist.model.dto.Comment;
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

}
