package com.akamai.AkamaiTask.Controllers;

import com.akamai.AkamaiTask.Services.SocialNetworkPostService;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
