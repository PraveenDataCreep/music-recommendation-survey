package rj.spring.musicrecommendation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rj.spring.musicrecommendation.entities.Song;
import rj.spring.musicrecommendation.services.RecommendationService;
import rj.spring.musicrecommendation.services.ResponseService;
import rj.spring.musicrecommendation.services.SongsService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mrs")
public class RecommendationController {

    private final SongsService songsService;
    private final ResponseService responseService;
    private final RecommendationService recommendationService;

    public RecommendationController(SongsService songsService, ResponseService responseService, RecommendationService recommendationService) {
        this.songsService = songsService;
        this.responseService = responseService;
        this.recommendationService = recommendationService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getHomePage(){
        return "recommendation/index";
    }

    @PostMapping("/search")
    public String searchSongs(@RequestParam String searchString, Model model){
        log.info("inside searchSongs");

        List<Song> songsByName = null;
        if(searchString.isEmpty()) {
            songsByName = new ArrayList<>();
            songsByName.add(Song.getEmptySong());
        }else{
            songsByName = songsService.getSongsByName(searchString);
        }
        if(songsByName.isEmpty()){
            songsByName.add(Song.getEmptySong());
        }
        model.addAttribute("songList", songsByName);
        model.addAttribute("resultTitle", "Search Results");
        return "recommendation/search-results.html";
    }

    @PostMapping("/recommend")
    public String generateRecommendations(@RequestParam String songid, Model model){
        log.info("inside generateRecommendations");

        if(songid.isEmpty()){
            return "recommendation/recommendations.html";
        }
        List<Song> songsByName = null;
        {
            songsByName = recommendationService.generateRecommendations(songid, 10);
        }
        if(songsByName.isEmpty()){
            songsByName.add(Song.getEmptySong());
        }
        model.addAttribute("songList", songsByName);
        model.addAttribute("songurl", "https://open.spotify.com/embed/track/"+songid);
        model.addAttribute("songid", songid);
        model.addAttribute("resultTitle", "Recommendations");
        return "recommendation/recommendations.html";
    }

    @PostMapping("/submitResponse")
    public String submitResponse(@RequestParam String songid, @RequestParam String jsonResponse, Model model){
        log.info("inside submitResponse");

        responseService.saveResponse(songid, jsonResponse);
        return "recommendation/thank-you.html";
    }

}
