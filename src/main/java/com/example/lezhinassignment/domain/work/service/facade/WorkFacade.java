package com.example.lezhinassignment.domain.work.service.facade;

import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkFacade {

    private final WorkRepository workRepository;

    public Work currentWork(Long workId) {
        return workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);
    }
}
