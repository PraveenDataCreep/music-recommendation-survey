package rj.spring.musicrecommendation.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "recommendations")
public class Recommendations {

    @Id
    private String id;

    private String name;
    private List<String> neighbors;

    public Recommendations(String name, List<String> neighbors) {
        this.name = name;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }
}
