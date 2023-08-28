package com.example.lezhinassignment.domain.work.controller;

import com.example.lezhinassignment.domain.work.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.service.WriteWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WriteWorkController {

    private final WriteWorkService writeWorkService;

    public void writeWork(WriteWorkRequest request) {
        writeWorkService.writeWork(request);
    }
}
