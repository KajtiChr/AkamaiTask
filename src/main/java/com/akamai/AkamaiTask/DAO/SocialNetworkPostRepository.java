package com.akamai.AkamaiTask.DAO;

import com.akamai.AkamaiTask.entities.SocialNetworkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {
}
