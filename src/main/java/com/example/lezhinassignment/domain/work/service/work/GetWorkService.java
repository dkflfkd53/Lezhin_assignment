package com.example.lezhinassignment.domain.work.service.work;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.enums.WorkType;
import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.entity.Visit;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.VisitRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetWorkService {

    private final UserFacade userFacade;
    private final WorkRepository workRepository;
    private final VisitRepository visitRepository;

    public WorkResponse getWork(Long workId) {
        LocalDateTime now = LocalDateTime.now();

        User user = userFacade.currentUser();

        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        if(work.getWorkType() == WorkType.ADULT)user.addAdultWork(work);

        user.updateVisitTime(now);

        visitRepository.save(
                Visit.builder()
                        .workId(workId)
                        .userId(user.getId())
                        .build());

        return new WorkResponse(work);
    }

}
