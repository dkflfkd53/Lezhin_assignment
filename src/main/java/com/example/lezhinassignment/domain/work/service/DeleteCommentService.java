package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Comment;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.CommentRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.CommentNotFoundException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final WorkRepository workRepository;
    private final CommentRepository commentRepository;

    public void deleteComment(Long workId) {
        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        Comment comment = commentRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> CommentNotFoundException.EXCEPTION);

        work.deleteComment(comment);
        commentRepository.delete(comment);
    }

}
