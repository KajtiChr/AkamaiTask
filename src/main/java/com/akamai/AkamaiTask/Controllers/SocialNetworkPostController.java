package com.akamai.AkamaiTask.Controllers;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.akamai.AkamaiTask.DAO.SocialNetworkPostRepository;
import com.akamai.AkamaiTask.Services.SocialNetworkPostService;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SocialNetworkPostController {

    @Autowired
    private SocialNetworkPostService socialNetworkPostService;

    @RequestMapping("/posts")
    public List<SocialNetworkPost> getAllPost(){
        return socialNetworkPostService.getAllPosts();
    }

    @RequestMapping("/topViews")
    public List<SocialNetworkPost> getTop10Posts(){
        return socialNetworkPostService.getTop10Posts();

    }

    @PutMapping("/put")
    public Optional<SocialNetworkPost> putPost(
            @RequestBody SocialNetworkPost socialNetworkPost,
            @RequestParam Long id){
        return socialNetworkPostService.changePost(socialNetworkPost, id);
    }

    @PostMapping("/post")
    public SocialNetworkPost post(
            @RequestBody SocialNetworkPost socialNetworkPost){
        return socialNetworkPostService.pushPost(socialNetworkPost);
    }

    @DeleteMapping("delete")
    public void delete(
            @RequestParam Long id) {
        socialNetworkPostService.delete(id);
    }


}
