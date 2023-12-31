package com.example.lezhinassignment.domain.work.service.disLike;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import com.example.lezhinassignment.global.exception.work.DisLikeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelDisLikeService {

    private final UserFacade userFacade;
    private final WorkFacade workFacade;
    private final DisLikeRepository disLikeRepository;

    public void cancelDisLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workFacade.currentWork(workId);

        DisLike disLike = disLikeRepository.findByUserIdAndWorkId(user.getId(), workId)
                .orElseThrow(()-> DisLikeNotFoundException.EXCEPTION);

        work.removeDisLike(disLike);
        disLikeRepository.delete(disLike);
    }

}
