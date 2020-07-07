package rj.spring.musicrecommendation.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import rj.spring.musicrecommendation.models.Songs;

@Getter
@Setter
@Slf4j
public class Song {

    private String song_id;
    private String artist;
    private String name;

    public static Song getEmptySong(){
        Song song = new Song();
        song.song_id = "";
        song.artist = "artists et al.";
        song.name = "Sorry, no results found";
        return song;
    }

    private Song(){

    }
    public Song(Songs song) {
        this.song_id = song.getSongId();
        String artistList = song.getArtists();
        artistList = artistList.replaceAll("['\\[\\]]", "");
        log.info("Artists: " + artistList);
        String[] split = artistList.split(",");
        if(split.length >0)
            this.artist = split[0] +" et al.";
        else
            this.artist = "";
        this.name = song.getName();
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_id='" + song_id + '\'' +
                ", artist='" + artist + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
