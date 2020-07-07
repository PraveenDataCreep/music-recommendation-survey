package rj.spring.musicrecommendation.repositories;

import org.springframework.data.repository.CrudRepository;
import rj.spring.musicrecommendation.models.AudioFeatures;

public interface AudioFeaturesRepository extends CrudRepository<AudioFeatures, Long> {
}
