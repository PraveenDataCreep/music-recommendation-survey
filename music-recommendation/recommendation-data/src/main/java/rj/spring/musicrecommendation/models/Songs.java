package rj.spring.musicrecommendation.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Songs {

    @Id
    private Long id;
    @Column(name = "song_id")
    private String songId;
    private String name;
    private String artists;
    private Integer explicit;
    private Integer mode;
    private Float popularity;
    private Float year;
    private Float duration_ms;

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id +
                ", songId='" + songId + '\'' +
                ", name='" + name + '\'' +
                ", artists='" + artists + '\'' +
                ", explicit='" + explicit + '\'' +
                ", mode=" + mode +
                ", popularity=" + popularity +
                ", year=" + year +
                ", duration_ms=" + duration_ms +
                '}';
    }
}
