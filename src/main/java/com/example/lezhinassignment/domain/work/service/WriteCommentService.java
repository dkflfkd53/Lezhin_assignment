package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Comment;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteCommentRequest;
import com.example.lezhinassignment.domain.work.repository.CommentRepository;
import com.example.lezhinassignment.global.exception.user.AlreadyCommentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    public void writeComment(WriteCommentRequest request, Long workId) {
        User user = userFacade.currentUser();

        if(commentRepository.findByUserId(user.getId()).isPresent()) {
            throw AlreadyCommentException.EXCEPTION;
        }

        commentRepository.save(
                Comment.builder()
                        .userId(user.getId())
                        .workId(workId)
                        .userName(user.getUserName())
                        .content(request.getContent())
                        .build());
    }

}
