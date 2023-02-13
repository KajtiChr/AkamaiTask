package com.akamai.AkamaiTask.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "socialnetworkpost")
@Data
@Component
public class SocialNetworkPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "post_date")
    private Date postDate;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;
    @Column(name = "view_count")
    private Long viewCount;

}
