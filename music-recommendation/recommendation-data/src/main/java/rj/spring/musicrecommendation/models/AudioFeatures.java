package rj.spring.musicrecommendation.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "scaled_features")
public class AudioFeatures {

    @Id
    private Long id;

    private Float acousticness;
    private Float danceability;
    private Float energy;
    private Float instrumentalness;
    private Float key;
    private Float liveness;
    private Float loudness;
    private Float speechiness;
    private Float tempo;
    private Float valence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(Float acousticness) {
        this.acousticness = acousticness;
    }

    public Float getDanceability() {
        return danceability;
    }

    public void setDanceability(Float danceability) {
        this.danceability = danceability;
    }

    public Float getEnergy() {
        return energy;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public Float getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(Float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public Float getKey() {
        return key;
    }

    public void setKey(Float key) {
        this.key = key;
    }

    public Float getLiveness() {
        return liveness;
    }

    public void setLiveness(Float liveness) {
        this.liveness = liveness;
    }

    public Float getLoudness() {
        return loudness;
    }

    public void setLoudness(Float loudness) {
        this.loudness = loudness;
    }

    public Float getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(Float speechiness) {
        this.speechiness = speechiness;
    }

    public Float getValence() {
        return valence;
    }

    public void setValence(Float valence) {
        this.valence = valence;
    }

    @Override
    public String toString() {
        return "AudioFeatures{" +
                "id=" + id +
                ", acousticness=" + acousticness +
                ", danceability=" + danceability +
                ", energy=" + energy +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                ", valence=" + valence +
                '}';
    }
}
