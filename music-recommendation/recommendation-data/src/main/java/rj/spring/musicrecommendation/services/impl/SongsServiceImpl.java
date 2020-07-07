package rj.spring.musicrecommendation.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.models.Songs;
import rj.spring.musicrecommendation.repositories.SongsRepository;
import rj.spring.musicrecommendation.services.SongsService;

import java.util.*;

@Slf4j
@Service
public class SongsServiceImpl implements SongsService {

    private final SongsRepository songsRepository;

    public SongsServiceImpl(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
        log.debug("Inside Songs Repository");

    }

    @Override
    public List<Song> getSongsByName(String searchString) {
        Optional<List<Songs>> byName = songsRepository.findByNameContainingIgnoreCase(searchString);

        if(byName.isPresent()){
            List<Songs> songsList = byName.get();
            songsList.sort(new Comparator<Songs>() {
                @Override
                public int compare(Songs songs, Songs t1) {
                    return  Math.round(t1.getPopularity()-songs.getPopularity());
                }
            });
            List<Song> resultList = new ArrayList();
            for(Songs song : songsList){
                Song songEntity = new Song(song);
                resultList.add(songEntity);
                if(resultList.size()==25)
                    break;
            }
            return resultList;
        }

        log.warn("No Song found by ", searchString);
        return new ArrayList<>();
    }

    @Override
    public Songs getSongsBySongId(String song_id) {
        Optional<Songs> bySongId = songsRepository.findBySongId(song_id);
        if(bySongId.isPresent()){
            return bySongId.get();
        }
        //TODO: handle better
        log.error("No Song found by Id ", song_id);
        return null;
    }

    @Override
    public Songs getSongsById(Long id) {
        Optional<Songs> byId = songsRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        //TODO: handle better.
        log.error("No Song found by Id ", id);
        return null;
    }

    @Override
    public Set<Songs> getTopKPopularSongs(PageRequest k) {
        Page<Songs> topKSongsByPopularity = songsRepository.findTopKSongsByPopularity(k);
        //TODO: handle pagination
        return null;
    }

}
