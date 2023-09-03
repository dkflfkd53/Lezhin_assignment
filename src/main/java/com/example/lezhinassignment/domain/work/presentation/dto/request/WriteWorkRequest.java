package com.example.lezhinassignment.domain.work.presentation.dto.request;

import com.example.lezhinassignment.domain.work.enums.WorkType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteWorkRequest {
    private String title;

    private WorkType workType;
}
