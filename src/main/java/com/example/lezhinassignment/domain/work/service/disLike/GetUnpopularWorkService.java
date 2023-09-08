package com.example.lezhinassignment.domain.work.service.disLike;

import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUnpopularWorkService {

    private final WorkRepository workRepository;

    public List<WorkResponse> getUnpopularWork() {
        return workRepository.findByLikes()
                .stream()
                .map(WorkResponse::new)
                .collect(Collectors.toList());
    }

}
