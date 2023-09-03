package com.example.lezhinassignment.domain.work.presentation;

import com.example.lezhinassignment.domain.user.presentation.dto.response.UserResponse;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteCommentRequest;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.service.*;
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
    private final AddLikeService addLikeService;
    private final AddDisLikeService addDisLikeService;
    private final WriteCommentService writeCommentService;
    private final GetPopularWorkService getPopularWorkService;
    private final GetUnpopularWorkService getUnpopularWorkService;

    @PostMapping("/work")
    public void writeWork(@Valid @RequestBody WriteWorkRequest request) {
        writeWorkService.writeWork(request);
    }

    @PostMapping("/work/like/{workId}")
    public void addLike(@PathVariable Long workId) {
        addLikeService.addLike(workId);
    }

    @PostMapping("/work/dis-like/{workId}")
    public void addDisLike(@PathVariable Long workId) {
        addDisLikeService.addDisLike(workId);
    }

    @PostMapping("/work/comment/{workId}")
    public void writeComment(@Valid @RequestBody WriteCommentRequest request, @PathVariable Long workId) {
        writeCommentService.writeComment(request, workId);
    }

    @GetMapping("/work/{workId}")
    public WorkResponse getWork(@PathVariable Long workId) {
        return getWorkService.getWork(workId);
    }

    @GetMapping("/work/record/{workId}")
    public List<UserResponse> getWorkRecord(@PathVariable Long workId) {
        return getWorkRecordService.getWorkRecord(workId);
    }

    @GetMapping("/work/popular")
    public List<Work> getPopularWork() {
        return getPopularWorkService.getPopularWork();
    }

    @GetMapping("/work/unpopular")
    public List<Work> getUnpopularWork() {
        return getUnpopularWorkService.getUnpopularWork();
    }

}
