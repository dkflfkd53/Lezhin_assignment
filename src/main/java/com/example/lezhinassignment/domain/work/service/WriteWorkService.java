package com.example.lezhinassignment.domain.work.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteWorkService {

    private final WorkRepository workRepository;

    public void writeWork() {
        workRepository.save
    }
}
