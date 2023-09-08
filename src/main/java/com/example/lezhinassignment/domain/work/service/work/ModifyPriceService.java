package com.example.lezhinassignment.domain.work.service.work;

import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.presentation.dto.request.ModifyPriceRequest;
import com.example.lezhinassignment.domain.work.service.facade.WorkFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyPriceService {

    private final WorkFacade workFacade;

    public void modifyPrice(ModifyPriceRequest request, Long workId) {
        Work work = workFacade.currentWork(workId);

        work.modifyPrice(request.getPrice());
    }

}
