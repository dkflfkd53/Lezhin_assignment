package com.example.lezhinassignment.domain.comment.repository;

import com.example.lezhinassignment.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByUserIdAndWorkId(Long userId, Long workId);
}
