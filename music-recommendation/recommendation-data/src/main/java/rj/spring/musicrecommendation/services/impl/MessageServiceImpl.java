package rj.spring.musicrecommendation.services.impl;

import org.springframework.stereotype.Service;
import rj.spring.musicrecommendation.models.Message;
import rj.spring.musicrecommendation.repositories.MessageRepository;
import rj.spring.musicrecommendation.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    private final MessageRepository messageRepository;

    @Override
    public void saveMessage(Message response) {
        messageRepository.insert(response);
    }
}
