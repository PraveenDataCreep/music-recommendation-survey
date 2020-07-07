package rj.spring.musicrecommendation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import rj.spring.musicrecommendation.models.Recommendations;

public interface RecommendationsRepository extends MongoRepository<Recommendations, String> {

    public Recommendations findByName(String name);
}
