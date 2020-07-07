package rj.spring.musicrecommendation.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;
import rj.spring.musicrecommendation.models.Responses;
import rj.spring.musicrecommendation.repositories.ResponsesRepository;
import rj.spring.musicrecommendation.services.ResponseService;

import java.util.Map;

@Slf4j
@Service
public class ResponseHandlerService implements ResponseService {

    private final ResponsesRepository responsesRepository;

    public ResponseHandlerService(ResponsesRepository responsesRepository) {
        this.responsesRepository = responsesRepository;
    }

    @Override
    public void saveResponse(String song_id, String response) {
        if(response.isEmpty() || song_id.isEmpty()){
            log.info("Aborted saving the response. Response or Song id Empty");
            log.info("song id: " + song_id + " response: " + response);
        }
        JacksonJsonParser jsObject = new JacksonJsonParser();
        Map<String, Object> stringObjectMap = jsObject.parseMap(response);
        Responses responses = new Responses(song_id, stringObjectMap);
        Responses insert = responsesRepository.insert(responses);
        log.info("saved responses: " + insert.toString());

    }
}
