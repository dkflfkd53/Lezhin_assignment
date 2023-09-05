package com.example.lezhinassignment.domain.work.service.disLike;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.user.AlreadyDisLikeException;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddDisLikeService {

    private final UserFacade userFacade;
    private final WorkRepository workRepository;
    private final DisLikeRepository disLikeRepository;
    private final LikeRepository likeRepository;

    public void addDisLike(Long workId) {
        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()->WorkNotFoundException.EXCEPTION);

        if(disLikeRepository.findByUserIdAndWorkId(user.getId(), workId).isPresent()) {
            throw AlreadyDisLikeException.EXCEPTION;
        }

        Optional<Like> likeOptional = likeRepository.findByUserIdAndWorkId(user.getId(), workId);

        if(likeOptional.isPresent()) {
            Like like = likeOptional.get();
            work.removeLike(like);
            likeRepository.delete(like);
        }

        DisLike disLike = disLikeRepository.save(
                DisLike.builder()
                        .userId(user.getId())
                        .workId(workId)
                        .build());

        work.addDisLike(disLike);
    }

}
