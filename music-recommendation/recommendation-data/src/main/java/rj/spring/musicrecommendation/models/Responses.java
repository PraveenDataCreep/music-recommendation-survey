package rj.spring.musicrecommendation.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document(collection = "responses")
public class Responses {

    @Id
    private String id;

    private String name;
    private Map<String, Object> responses;
    private Long date;

    public Responses(String name, Map<String, Object> responses) {
        this.name = name;
        this.responses = responses;
        this.date = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Responses{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", responses=" + responses +
                '}';
    }
}
