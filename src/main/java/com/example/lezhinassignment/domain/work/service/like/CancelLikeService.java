package com.example.lezhinassignment.domain.work.service.like;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.LikeNotFoundException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelLikeService {

    private final LikeRepository likeRepository;
    private final WorkRepository workRepository;
    private final UserFacade userFacade;

    public void cancelLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        Like like = likeRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> LikeNotFoundException.EXCEPTION);

        work.removeLike(like);
        likeRepository.delete(like);
    }
}
