package com.example.lezhinassignment.domain.work.presentation;

import com.example.lezhinassignment.domain.user.presentation.dto.response.UserResponse;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.service.GetWorkRecordService;
import com.example.lezhinassignment.domain.work.service.GetWorkService;
import com.example.lezhinassignment.domain.work.service.WriteWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkController {

    private final WriteWorkService writeWorkService;
    private final GetWorkService getWorkService;
    private final GetWorkRecordService getWorkRecordService;

    @PostMapping("/work")
    public void writeWork(@Valid @RequestBody WriteWorkRequest request) {
        writeWorkService.writeWork(request);
    }

    @GetMapping("/work/{workId}")
    public WorkResponse getWork(@PathVariable Long workId) {
        return getWorkService.getWork(workId);
    }

    @GetMapping("/work-record/{workId}")
    public List<UserResponse> getWorkRecord(@PathVariable Long workId) {
        return getWorkRecordService.getWorkRecord(workId);
    }

}