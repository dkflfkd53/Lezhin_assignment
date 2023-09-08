package com.example.lezhinassignment.domain.work.service.comment;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Comment;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.CommentRepository;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final WorkFacade workFacade;
    private final CommentRepository commentRepository;

    public void deleteComment(Long workId) {
        User user = userFacade.currentUser();

        Work work = workFacade.currentWork(workId);

        Comment comment = workFacade.currentComment(user.getId(), workId);

        work.deleteComment(comment);
        commentRepository.delete(comment);
    }

}
