package com.example.lezhinassignment.domain.work.controller;

import com.example.lezhinassignment.domain.work.service.WriteWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WriteWorkController {

    private final WriteWorkService writeWorkService;

    public void writeWork(WorkRequest request) {
        writeWorkService.writeWork();
    }
}
