package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.DisLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisLikeRepository extends JpaRepository<DisLike, Long> {
    void deleteByWorkId(Long workId);
}
