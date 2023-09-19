package com.example.lezhinassignment.domain.work.presentation;

import com.example.lezhinassignment.domain.user.presentation.dto.response.UserResponse;
import com.example.lezhinassignment.domain.work.presentation.dto.request.ModifyPriceRequest;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.service.disLike.AddDisLikeService;
import com.example.lezhinassignment.domain.work.service.disLike.CancelDisLikeService;
import com.example.lezhinassignment.domain.work.service.disLike.GetUnpopularWorkService;
import com.example.lezhinassignment.domain.work.service.like.AddLikeService;
import com.example.lezhinassignment.domain.work.service.like.CancelLikeService;
import com.example.lezhinassignment.domain.work.service.like.GetPopularWorkService;
import com.example.lezhinassignment.domain.work.service.work.GetWorkRecordService;
import com.example.lezhinassignment.domain.work.service.work.GetWorkService;
import com.example.lezhinassignment.domain.work.service.work.ModifyPriceService;
import com.example.lezhinassignment.domain.work.service.work.WriteWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkController {

    //work
    private final WriteWorkService writeWorkService;
    private final GetWorkService getWorkService;
    private final GetWorkRecordService getWorkRecordService;
    private final ModifyPriceService modifyPriceService;

    //like
    private final AddLikeService addLikeService;
    private final GetPopularWorkService getPopularWorkService;
    private final CancelLikeService cancelLikeService;

    //dislike
    private final AddDisLikeService addDisLikeService;
    private final GetUnpopularWorkService getUnpopularWorkService;
    private final CancelDisLikeService cancelDisLikeService;

    //work
    @PostMapping("/work")
    public void writeWork(@Valid @RequestBody WriteWorkRequest request) {
        writeWorkService.writeWork(request);
    }

    @GetMapping("/work/{workId}")
    public WorkResponse getWork(@PathVariable Long workId) {
        return getWorkService.getWork(workId);
    }

    @GetMapping("/work/record/{workId}")
    public List<UserResponse> getWorkRecord(@PathVariable Long workId) {
        return getWorkRecordService.getWorkRecord(workId);
    }

    @PatchMapping("/work/price/{workId}")
    public void modifyPrice(@Valid @RequestBody ModifyPriceRequest request, @PathVariable Long workId) {
        modifyPriceService.modifyPrice(request, workId);
    }

    //like
    @PostMapping("/work/like/{workId}")
    public void addLike(@PathVariable Long workId) {
        addLikeService.addLike(workId);
    }

    @GetMapping("/work/popular")
    public List<WorkResponse> getPopularWork() {
        return getPopularWorkService.getPopularWork();
    }

    @DeleteMapping("/work/like/{workId}")
    public void cancelLike(@PathVariable Long workId) {
        cancelLikeService.cancelLike(workId);
    }

    //disLike
    @PostMapping("/work/dis-like/{workId}")
    public void addDisLike(@PathVariable Long workId) {
        addDisLikeService.addDisLike(workId);
    }

    @GetMapping("/work/unpopular")
    public List<WorkResponse> getUnpopularWork() {
        return getUnpopularWorkService.getUnpopularWork();
    }

    @DeleteMapping("/work/dis-like/{workId}")
    public void cancelDisLike(@PathVariable Long workId) {
        cancelDisLikeService.cancelDisLike(workId);
    }

}
