package com.example.lezhinassignment.domain.work.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class ModifyPriceRequest {

    private Long price;
}
