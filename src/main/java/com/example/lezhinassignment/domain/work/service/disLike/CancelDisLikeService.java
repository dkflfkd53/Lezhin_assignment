package com.example.lezhinassignment.domain.work.service.disLike;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.DisLikeNotFoundException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelDisLikeService {

    private final WorkRepository workRepository;
    private final DisLikeRepository disLikeRepository;
    private final UserFacade userFacade;

    public void cancelDisLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        DisLike disLike = disLikeRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> DisLikeNotFoundException.EXCEPTION);

        work.removeDisLike(disLike);
        disLikeRepository.delete(disLike);
    }

}
