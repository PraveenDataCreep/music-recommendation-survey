package rj.spring.musicrecommendation.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.models.AudioFeatures;
import rj.spring.musicrecommendation.models.Recommendations;
import rj.spring.musicrecommendation.models.Songs;
import rj.spring.musicrecommendation.services.AudioFeaturesService;
import rj.spring.musicrecommendation.services.RecommendationService;
import rj.spring.musicrecommendation.services.SongsService;

import java.util.List;

@Slf4j
@Component
public class MusicRecommendationBootstrap implements CommandLineRunner {

    private final AudioFeaturesService audioFeaturesService;
    private final SongsService songsService;
    private final RecommendationService recommendationService;

    public MusicRecommendationBootstrap(AudioFeaturesService audioFeaturesService, SongsService songsService,
                                        RecommendationService recommendationService) {
        this.audioFeaturesService = audioFeaturesService;
        this.songsService = songsService;
        this.recommendationService = recommendationService;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("audio feature service: Starting inspection");
        AudioFeatures audioFeatureById = audioFeaturesService.getAudioFeatureById(0L);
        if(audioFeatureById != null)
            log.info(audioFeatureById.toString());
        log.info("audio feature service: Done inspection");

        log.info("songs service: Starting inspection");

        log.info("song by id");
        Songs songsById = songsService.getSongsById(0L);
        if(songsById != null){
            log.info(songsById.toString());
        }

        log.info("song by song id");
        Songs songsBySongId = songsService.getSongsBySongId("0swl1tZWBEBOdRVPN6axXe");
        log.info(songsBySongId.toString());


        log.info("song by name");
        List<Song> all_i_want = songsService.getSongsByName("All I want");
        for(Song song : all_i_want){
            log.info(song.toString());
        }

        log.info("song neighbors");
        Recommendations neighbors = recommendationService.findNeighbors("0swl1tZWBEBOdRVPN6axXe");
        log.info(neighbors.toString());

        log.info("songs service: Done inspection");

    }
}
