package com.example.lezhinassignment.domain.work.presentation.dto.response;

import com.example.lezhinassignment.domain.work.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkResponse {

    private Long id;
    private String title;

    public WorkResponse(Work work) {
        id = work.getId();
        title = work.getTitle();
    }

}
