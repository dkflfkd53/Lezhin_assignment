package com.example.lezhinassignment.domain.comment.service;

import com.example.lezhinassignment.domain.comment.entity.Comment;
import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.comment.presentation.dto.request.CommentRequest;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyCommentService {

    private final UserFacade userFacade;

    private final WorkFacade workFacade;

    public void modifyComment(CommentRequest request, Long workId) {
        User user = userFacade.currentUser();

        Comment comment = workFacade.currentComment(user.getId(), workId);

        comment.modifyComment(request.getContent());
    }

}
