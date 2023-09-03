package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.entity.Visit;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.VisitRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetWorkService {

    private final WorkRepository workRepository;
    private final VisitRepository visitRepository;
    private final UserFacade userFacade;

    public WorkResponse getWork(Long workId) {
        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        User user = userFacade.currentUser();

        visitRepository.save(
                Visit.builder()
                        .workId(work.getId())
                        .userId(user.getId())
                        .build());

        return new WorkResponse(work);
    }

}
