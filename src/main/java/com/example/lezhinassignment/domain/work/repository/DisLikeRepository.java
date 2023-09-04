package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.DisLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisLikeRepository extends JpaRepository<DisLike, Long> {
    Optional<DisLike> findByUserIdAndWorkId(Long userId, Long workId);
}
