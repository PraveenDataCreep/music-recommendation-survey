package rj.spring.musicrecommendation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import rj.spring.musicrecommendation.models.Responses;

public interface ResponsesRepository extends MongoRepository<Responses, String> {
}
