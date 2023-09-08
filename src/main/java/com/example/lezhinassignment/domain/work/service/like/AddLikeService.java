package com.example.lezhinassignment.domain.work.service.like;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import com.example.lezhinassignment.global.exception.user.AlreadyLikeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddLikeService {

    private final UserFacade userFacade;
    private final WorkFacade workFacade;
    private final LikeRepository likeRepository;
    private final DisLikeRepository disLikeRepository;

    public void addLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workFacade.currentWork(workId);

        if(likeRepository.findByUserIdAndWorkId(user.getId(), workId).isPresent()) {
            throw AlreadyLikeException.EXCEPTION;
        }

        Optional<DisLike> disLikeOptional = disLikeRepository.findByUserIdAndWorkId(user.getId(), workId);

        if(disLikeOptional.isPresent()) {
            DisLike disLike = disLikeOptional.get();
            work.removeDisLike(disLike);
            disLikeRepository.delete(disLike);
        }

        Like like = likeRepository.save(
                Like.builder()
                        .user(user)
                        .work(work)
                        .build());

        work.addLike(like);
    }

}
