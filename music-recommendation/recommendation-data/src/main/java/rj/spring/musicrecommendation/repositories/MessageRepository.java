package rj.spring.musicrecommendation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import rj.spring.musicrecommendation.models.Message;

public interface MessageRepository  extends MongoRepository<Message, String> {
}
