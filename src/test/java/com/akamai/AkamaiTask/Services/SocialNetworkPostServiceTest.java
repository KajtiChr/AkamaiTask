package com.akamai.AkamaiTask.Services;

import com.akamai.AkamaiTask.DAO.SocialNetworkPostRepository;
import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class SocialNetworkPostServiceTest {

    @Mock
    private SocialNetworkPostRepository studentRepository;
    private SocialNetworkPostService underTest;

    @BeforeEach
    void setUp(){
        underTest = new SocialNetworkPostService(studentRepository);
    }

    @Test
    void getAllPosts() {
        underTest.getAllPosts();

        verify(studentRepository).findAll();
    }

    @Test
    void getTop10Posts() {
        underTest.getTop10Posts();

        verify(studentRepository).findAll().stream()
                .sorted(Comparator.comparing(SocialNetworkPost::getViewCount).reversed())
                .limit(10);
    }
}