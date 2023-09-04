package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.user.AlreadyLikeException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddLikeService {

    private final LikeRepository likeRepository;
    private final DisLikeRepository disLikeRepository;
    private final WorkRepository workRepository;
    private final UserFacade userFacade;

    public void addLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()->WorkNotFoundException.EXCEPTION);

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
                        .userId(user.getId())
                        .workId(workId)
                        .build());

        work.addLike(like);
    }

}
