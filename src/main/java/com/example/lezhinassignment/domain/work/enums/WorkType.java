package com.example.lezhinassignment.domain.work.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WorkType {

    GENERAL("일반"),
    ADULT("성인"),

    ;

    private final String name;
}
