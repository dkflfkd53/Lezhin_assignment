package com.example.lezhinassignment.domain.work.service.facade;

import com.example.lezhinassignment.domain.comment.entity.Comment;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.comment.repository.CommentRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.CommentNotFoundException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkFacade {

    private final WorkRepository workRepository;
    private final CommentRepository commentRepository;

    public Work currentWork(Long workId) {
        return workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);
    }

    public Comment currentComment(Long userId, Long workId) {
        return commentRepository.findByUserIdAndWorkId(userId, workId)
                .orElseThrow(()-> CommentNotFoundException.EXCEPTION);
    }

}
