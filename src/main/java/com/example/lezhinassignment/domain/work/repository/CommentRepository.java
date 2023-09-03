package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByUserId(Long userId);
}
