package com.example.lezhinassignment.domain.comment.service;

import com.example.lezhinassignment.domain.comment.entity.Comment;
import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.comment.presentation.dto.request.WriteCommentRequest;
import com.example.lezhinassignment.domain.comment.repository.CommentRepository;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import com.example.lezhinassignment.global.exception.user.AlreadyCommentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteCommentService {

    private final UserFacade userFacade;

    private final WorkFacade workFacade;

    private final CommentRepository commentRepository;

    public void writeComment(WriteCommentRequest request, Long workId) {
        User user = userFacade.currentUser();

        Work work = workFacade.currentWork(workId);

        if(commentRepository.findByUserIdAndWorkId(user.getId(), workId).isPresent()) {
            throw AlreadyCommentException.EXCEPTION;
        }

        Comment comment = commentRepository.save(
                Comment.builder()
                        .user(user)
                        .work(work)
                        .content(request.getContent())
                        .build());

        work.writeComment(comment);
    }

}
