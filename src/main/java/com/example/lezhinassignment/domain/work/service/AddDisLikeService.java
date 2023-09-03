package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.user.AlreadyDisLikeException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddDisLikeService {

    private final DisLikeRepository disLikeRepository;
    private final LikeRepository likeRepository;
    private final WorkRepository workRepository;
    private final UserFacade userFacade;

    public void addDisLike(Long workId) {
        User user = userFacade.currentUser();

        if(!workRepository.existsById(workId)) {
            throw WorkNotFoundException.EXCEPTION;
        }

        if(disLikeRepository.findByUserIdAndWorkId(user.getId(), workId).isPresent()) {
            throw AlreadyDisLikeException.EXCEPTION;
        }

        likeRepository.deleteByWorkId(workId);

        disLikeRepository.save(
                DisLike.builder()
                        .userId(user.getId())
                        .workId(workId)
                        .build());
    }
}
