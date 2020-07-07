package rj.spring.musicrecommendation.services;

import rj.spring.musicrecommendation.models.AudioFeatures;

import java.util.Set;

public interface AudioFeaturesService {

    public Set<AudioFeatures> getAllAudioFeatures();
    public AudioFeatures getAudioFeatureById(Long id);

}
