package rj.spring.musicrecommendation.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.models.Recommendations;
import rj.spring.musicrecommendation.models.Songs;
import rj.spring.musicrecommendation.repositories.RecommendationsRepository;
import rj.spring.musicrecommendation.repositories.SongsRepository;
import rj.spring.musicrecommendation.services.RecommendationService;

import java.util.*;

@Slf4j
@Service
public class RecommendationGenerator implements RecommendationService {

    private final RecommendationsRepository recommendationsRepository;
    private final SongsRepository songsRepository;

    public RecommendationGenerator(RecommendationsRepository recommendationsRepository, SongsRepository songsRepository) {
        this.recommendationsRepository = recommendationsRepository;
        this.songsRepository = songsRepository;
    }

    @Override
    public Recommendations findNeighbors(String name) {
        log.debug("Inside findByName");
        Recommendations byName = recommendationsRepository.findByName(name);

        if(byName != null)
            return byName;
        log.error("No Song found with id: ", name);
        log.error(name);
        return null;
    }

    @Override
    public List<Song> generateRecommendations(String song_id, int capacity) {
        int counter = 0;
        Recommendations recommendations = findNeighbors(song_id);
        Queue<String> queue = new LinkedList<>(recommendations.getNeighbors());
        Set<String> recommendedIds = new HashSet<>(recommendations.getNeighbors());
        List<Song> recommendedSongs = new ArrayList<>();
        while(!queue.isEmpty() && recommendedIds.size() < capacity && counter<100){
            String id = queue.poll();
            Recommendations temps = findNeighbors(id);
            for(String rec: temps.getNeighbors()){
                if(rec.equalsIgnoreCase(song_id))
                    continue;
                recommendedIds.add(rec);
                queue.add(rec);
            }
            counter++;
        }
        log.info("Took "+ counter + " depth");
        List<Songs> allBySongId = songsRepository.findAllBySongIdIn(recommendedIds);
        allBySongId.sort(new Comparator<Songs>() {
            @Override
            public int compare(Songs songs, Songs t1) {
                return Math.round(t1.getPopularity()-songs.getPopularity());
            }
        });
        allBySongId.forEach((element) ->{
            recommendedSongs.add(new Song(element));
        });
        return recommendedSongs;
    }
}
