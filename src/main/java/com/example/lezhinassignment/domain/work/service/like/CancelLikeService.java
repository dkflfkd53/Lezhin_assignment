package com.example.lezhinassignment.domain.work.service.like;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import com.example.lezhinassignment.global.exception.work.LikeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelLikeService {

    private final UserFacade userFacade;
    private final WorkFacade workFacade;
    private final LikeRepository likeRepository;

    public void cancelLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workFacade.currentWork(workId);

        Like like = likeRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> LikeNotFoundException.EXCEPTION);

        work.removeLike(like);
        likeRepository.delete(like);
    }

}
