package com.example.lezhinassignment.domain.work.controller;

import com.example.lezhinassignment.domain.work.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.service.GetWorkRecordService;
import com.example.lezhinassignment.domain.work.service.GetWorkService;
import com.example.lezhinassignment.domain.work.service.WriteWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WriteWorkService writeWorkService;
    private final GetWorkService getWorkService;
    private final GetWorkRecordService getWorkRecordService;

    @PostMapping("/work")
    public void writeWork(WriteWorkRequest request) {
        writeWorkService.writeWork(request);
    }

    @GetMapping("/work/{workId}")
    public WorkResponse getWork(@PathVariable Long workId) {
        return getWorkService.getWork(workId);
    }

    @GetMapping("/work-record/{workId}")
    public WorkRecordResponse getWorkRecord(@PathVariable Long wordId) {
        return getWorkRecordService.getWorkRecord(wordId);
    }

}
