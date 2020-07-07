package rj.spring.musicrecommendation.services;


import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.models.Recommendations;

import java.util.List;

public interface RecommendationService {

    public Recommendations findNeighbors(String name);

    public List<Song> generateRecommendations(String song_id, int capacity);
}
