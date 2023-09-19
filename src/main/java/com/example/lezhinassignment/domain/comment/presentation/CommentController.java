package com.example.lezhinassignment.domain.comment.presentation;

import com.example.lezhinassignment.domain.comment.presentation.dto.request.CommentRequest;
import com.example.lezhinassignment.domain.comment.presentation.dto.request.WriteCommentRequest;
import com.example.lezhinassignment.domain.comment.service.DeleteCommentService;
import com.example.lezhinassignment.domain.comment.service.ModifyCommentService;
import com.example.lezhinassignment.domain.comment.service.WriteCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final WriteCommentService writeCommentService;

    private final ModifyCommentService modifyCommentService;

    private final DeleteCommentService deleteCommentService;

    @PostMapping("/work/comment/{workId}")
    public void writeComment(@Valid @RequestBody WriteCommentRequest request, @PathVariable Long workId) {
        writeCommentService.writeComment(request, workId);
    }
    @PatchMapping("/work/comment/{workId}")
    public void modifyComment(@Valid @RequestBody CommentRequest request, @PathVariable Long workId) {
        modifyCommentService.modifyComment(request, workId);
    }
    @DeleteMapping("/work/comment/{workId}")
    public void deleteComment(@PathVariable Long workId) {
        deleteCommentService.deleteComment(workId);
    }

}
