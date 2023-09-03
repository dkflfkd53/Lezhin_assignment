package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteWorkService {

    private final WorkRepository workRepository;

    public void writeWork(WriteWorkRequest request) {
        workRepository.save(
                Work.builder()
                        .title(request.getTitle())
                        .workType(request.getWorkType())
                        .build());
    }
}
