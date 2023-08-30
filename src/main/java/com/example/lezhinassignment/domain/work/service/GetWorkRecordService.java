package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetWorkRecordService {

    private final WorkRepository workRepository;

    public WorkRecordResponse getWorkRecord(Long workId) {
        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        return new WorRecordResponse
    }
}
