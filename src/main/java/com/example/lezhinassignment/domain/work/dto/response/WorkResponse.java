package com.example.lezhinassignment.domain.work.dto.response;

import com.example.lezhinassignment.domain.work.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkResponse {

    private String title;

    public WorkResponse(Work work) {
        title = work.getTitle();
    }

}
