package com.akamai.AkamaiTask.Services;

import com.akamai.AkamaiTask.DAO.SocialNetworkPostRepository;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SocialNetworkPostService {
    @Autowired
    private SocialNetworkPostRepository socialNetworkPostRepository;

    public SocialNetworkPostService(SocialNetworkPostRepository studentRepository) {
        this.socialNetworkPostRepository = studentRepository;
    }

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

    public SocialNetworkPost pushPost(SocialNetworkPost socialNetworkPost){
        socialNetworkPost.setPostDate(new Date());
        return socialNetworkPostRepository.save(socialNetworkPost);
    }


    @Transactional(rollbackFor = Exception.class)
    public Optional<SocialNetworkPost> changePost(SocialNetworkPost socialNetworkPost, Long id){

        return Optional.of(socialNetworkPostRepository.findById(id)
                .map(post -> {
                    post.setAuthor(socialNetworkPost.getAuthor());
                    post.setContent(socialNetworkPost.getContent());
                    post.setViewCount(socialNetworkPost.getViewCount());
                    return socialNetworkPostRepository.save(post);

                })
                .orElseGet(() -> socialNetworkPostRepository.save(socialNetworkPost)));
    }

    public void delete(Long id) {
         socialNetworkPostRepository.deleteById(id);
    }
}
