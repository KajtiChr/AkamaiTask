package com.akamai.AkamaiTask.Controllers;

import com.akamai.AkamaiTask.Services.SocialNetworkPostService;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocialNetworkPostControllerTest {

    @InjectMocks
    SocialNetworkPostController socialNetworkPostController;

    @Mock
    SocialNetworkPostService socialNetworkPostService;



    @Test
    void getAllPost() {

        SocialNetworkPost socialNetworkPost1 = new SocialNetworkPost(1l, new Date(), "Kajetan Chrzanowski", "content", 5l);
        SocialNetworkPost socialNetworkPost2 = new SocialNetworkPost(2l, new Date(), "B G", "content-MS", 1000l);

        List<SocialNetworkPost> list = Arrays.asList(socialNetworkPost1, socialNetworkPost2);

        when(socialNetworkPostService.getAllPosts()).thenReturn(list);

        List<SocialNetworkPost> result = socialNetworkPostController.getAllPost();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAuthor()).isEqualTo(socialNetworkPost1.getAuthor());
        assertThat(result.get(1).getAuthor()).isEqualTo(socialNetworkPost2.getAuthor());
    }

    @Test
    void getTop10Posts(){

        SocialNetworkPost socialNetworkPost1 = new SocialNetworkPost(1l, new Date(), "Kajetan Chrzanowski", "content", 5l);
        SocialNetworkPost socialNetworkPost2 = new SocialNetworkPost(2l, new Date(), "B G", "content-MS", 1000l);
        SocialNetworkPost socialNetworkPost3 = new SocialNetworkPost(3l, new Date(), "B G", "content-MS", 24l);
        SocialNetworkPost socialNetworkPost4 = new SocialNetworkPost(4l, new Date(), "B G", "content-MS", 100l);
        SocialNetworkPost socialNetworkPost5 = new SocialNetworkPost(5l, new Date(), "B G", "content-MS", 1050l);
        SocialNetworkPost socialNetworkPost6 = new SocialNetworkPost(6l, new Date(), "B G", "content-MS", 10230l);
        SocialNetworkPost socialNetworkPost7 = new SocialNetworkPost(7l, new Date(), "B G", "content-MS", 623l);
        SocialNetworkPost socialNetworkPost8 = new SocialNetworkPost(8l, new Date(), "B G", "content-MS", 120l);
        SocialNetworkPost socialNetworkPost9 = new SocialNetworkPost(9l, new Date(), "B G", "content-MS", 6340l);
        SocialNetworkPost socialNetworkPost10 = new SocialNetworkPost(10l, new Date(), "B G", "content-MS", 620l);
        SocialNetworkPost socialNetworkPost11 = new SocialNetworkPost(11l, new Date(), "B G", "content-MS", 163l);

        List<SocialNetworkPost> list = Arrays.asList(socialNetworkPost1, socialNetworkPost2, socialNetworkPost3, socialNetworkPost4,
                socialNetworkPost5, socialNetworkPost6, socialNetworkPost7, socialNetworkPost8, socialNetworkPost9, socialNetworkPost10, socialNetworkPost11);
        List<SocialNetworkPost> revList = new ArrayList<>();
        list.stream()
                .sorted(Comparator.comparing(SocialNetworkPost::getViewCount).reversed())
                .limit(10)
                .forEach(revList::add);

        when(socialNetworkPostService.getTop10Posts()).thenReturn(revList);

        List<SocialNetworkPost> result = socialNetworkPostController.getTop10Posts();

        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).getViewCount()).isEqualTo(10230l);

    }
}