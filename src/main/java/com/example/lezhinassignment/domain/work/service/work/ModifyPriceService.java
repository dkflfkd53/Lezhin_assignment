package com.example.lezhinassignment.domain.work.service.work;

import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.presentation.dto.request.ModifyPriceRequest;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import com.example.lezhinassignment.global.exception.work.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyPriceService {

    private final WorkRepository workRepository;

    public void modifyPrice(ModifyPriceRequest request, Long workId) {
        Work work = workRepository.findById(workId)
                .orElseThrow(()-> WorkNotFoundException.EXCEPTION);

        work.modifyPrice(request.getPrice());
    }
}
