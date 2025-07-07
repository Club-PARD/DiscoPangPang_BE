package com.pard.server.discoPangPang_BE.star.repo;


import com.pard.server.discoPangPang_BE.star.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface StarRepo extends JpaRepository<Star, Long> {
    Optional<Star> findByProjectId(String projectId);
}
