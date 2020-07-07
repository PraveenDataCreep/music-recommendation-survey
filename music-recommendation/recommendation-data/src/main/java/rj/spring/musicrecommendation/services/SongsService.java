package rj.spring.musicrecommendation.services;

import org.springframework.data.domain.PageRequest;
import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.models.Songs;

import java.util.List;
import java.util.Set;

public interface SongsService {

    public List<Song> getSongsByName(String searchString);
    public Songs getSongsBySongId(String song_id);
    public Songs getSongsById(Long id);
    public Set<Songs> getTopKPopularSongs(PageRequest k);
}
