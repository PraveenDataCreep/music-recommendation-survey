package rj.spring.musicrecommendation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rj.spring.musicrecommendation.models.Message;
import rj.spring.musicrecommendation.services.MessageService;

@Slf4j
@Controller
public class ProfileController {

    private final MessageService messageService;

    public ProfileController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getHomePage(){
        return "index";
    }

    @RequestMapping("/projects")
    public String getProjects(){
        return "projects";
    }

    @RequestMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @PostMapping("/submit")
    public String submitRequest(@RequestParam String name,
                                @RequestParam String email, @RequestParam String subject,
                                @RequestParam String msg){

        Message message = new Message(name, email, subject, msg);
        messageService.saveMessage(message);
        return "contactsubmission";
    }


}
