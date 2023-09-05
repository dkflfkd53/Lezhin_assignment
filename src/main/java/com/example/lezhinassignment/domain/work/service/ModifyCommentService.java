package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Comment;
import com.example.lezhinassignment.domain.work.presentation.dto.request.CommentRequest;
import com.example.lezhinassignment.domain.work.repository.CommentRepository;
import com.example.lezhinassignment.global.exception.work.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    public void modifyComment(CommentRequest request, Long workId) {
        User user = userFacade.currentUser();

        Comment comment = commentRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> CommentNotFoundException.EXCEPTION);

        comment.modifyComment(request.getContent());
    }
}
