package com.akamai.AkamaiTask.Services;

import com.akamai.AkamaiTask.DAO.SocialNetworkPostRepository;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SocialNetworkPostService {
    @Autowired
    private SocialNetworkPostRepository socialNetworkPostRepository;

    public List<SocialNetworkPost> getAllPosts(){
        List<SocialNetworkPost> socialNetworkPosts = new ArrayList<>();
        socialNetworkPostRepository.findAll().forEach((socialNetworkPosts::add));
        return socialNetworkPosts;
    }

    public List<SocialNetworkPost> getTop10Posts() {
        List<SocialNetworkPost> socialNetworkPosts = new ArrayList<>();

        socialNetworkPostRepository.findAll().stream()
                .sorted(Comparator.comparing(SocialNetworkPost::getViewCount).reversed())
                .limit(10)
                .forEach(socialNetworkPosts::add);
        return socialNetworkPosts;
    }
}
