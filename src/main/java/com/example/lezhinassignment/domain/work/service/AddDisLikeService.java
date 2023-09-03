package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddDisLikeService {

    private final DisLikeRepository disLikeRepository;
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;

    public void addDisLike(Long workId) {
        User user = userFacade.currentUser();

        likeRepository.deleteByWorkId(workId);

        disLikeRepository.save(
                DisLike.builder()
                        .userId(user.getId())
                        .workId(workId)
                        .build());
    }
}
