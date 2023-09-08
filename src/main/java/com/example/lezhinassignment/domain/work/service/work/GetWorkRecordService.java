package com.example.lezhinassignment.domain.work.service.work;

import com.example.lezhinassignment.domain.user.presentation.dto.response.UserResponse;
import com.example.lezhinassignment.domain.work.entity.Visit;
import com.example.lezhinassignment.domain.work.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetWorkRecordService {

    private final VisitRepository visitRepository;

    public List<UserResponse> getWorkRecord(Long workId) {
        return visitRepository.findAllByWorkId(workId)
                .stream()
                .map(Visit::getUser)
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

}
