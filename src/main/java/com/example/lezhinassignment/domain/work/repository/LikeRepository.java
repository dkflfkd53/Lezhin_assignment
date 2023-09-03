package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByWorkId(Long workId);
}
