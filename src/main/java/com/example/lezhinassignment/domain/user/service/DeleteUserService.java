package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.VisitRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteUserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final WorkRepository workRepository;
    private final VisitRepository visitRepository;
    private final LikeRepository likeRepository;
    private final DisLikeRepository disLikeRepository;

    public void deleteUser() {
        User user = userFacade.currentUser();
        visitRepository.deleteAllByUser(user);
        likeRepository.deleteAllByUser(user);
        disLikeRepository.deleteAllByUser(user);
        workRepository.deleteAllByUser(user);
        userRepository.delete(user);
    }

}
//댓글, 방문기록, 좋아요, 싫어요, 작품