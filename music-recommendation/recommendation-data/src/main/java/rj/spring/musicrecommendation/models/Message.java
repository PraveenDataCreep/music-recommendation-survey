package rj.spring.musicrecommendation.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "messages")
public class Message {
    @Id
    private String id;

    private String name;
    private String email;
    private String subject;
    private String message;
    private Long date;

    public Message(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.date = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
