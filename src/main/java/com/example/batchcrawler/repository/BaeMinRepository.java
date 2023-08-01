package com.example.batchcrawler.repository;

import com.example.batchcrawler.entity.BaeMinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BaeMinRepository extends JpaRepository<BaeMinEntity, Long> {
    BaeMinEntity findByPostId(@Param("postId") String postId);
}
