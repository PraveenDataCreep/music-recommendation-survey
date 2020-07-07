package rj.spring.musicrecommendation.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rj.spring.musicrecommendation.models.AudioFeatures;
import rj.spring.musicrecommendation.repositories.AudioFeaturesRepository;
import rj.spring.musicrecommendation.services.AudioFeaturesService;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AudioFeaturesServiceImpl implements AudioFeaturesService {

    private final AudioFeaturesRepository audioFeaturesRepository;

    public AudioFeaturesServiceImpl(AudioFeaturesRepository audioFeaturesRepository) {
        this.audioFeaturesRepository = audioFeaturesRepository;
        log.debug("Inside Audio Features repository");
    }

    @Override
    public Set<AudioFeatures> getAllAudioFeatures() {
        //TODO: this will be used to fetch all the features are calculate the euclidean.

        return null;
    }

    @Override
    public AudioFeatures getAudioFeatureById(Long id) {

        Optional<AudioFeatures> byId = audioFeaturesRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        //TODO: handle better
        log.error("No Song found by the id ", id);
        return null;
    }
}
