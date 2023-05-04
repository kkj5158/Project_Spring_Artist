package com.artist.domain.artisthome;

import com.artist.model.dto.Artist;
import com.artist.model.dto.Comment;

import java.util.List;

public interface ArtisthomeService {

    public Artist getartistinfobyid(int artistid);

    public List<Artist> getAllArtistinfo();

    public List<Comment> getArtistComment(int artist_id);
    public Comment getIdComment(int id);

    public void createComment(Comment comment);

    public void modifyComment(Comment comment);
    public void deleteComment(int id);
}
