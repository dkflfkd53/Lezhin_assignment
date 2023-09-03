package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.work.entity.DisLike;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.DisLikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUnpopularWorkService {

    private final WorkRepository workRepository;
    private final DisLikeRepository disLikeRepository;

    public List<Work> getUnpopularWork() {
        List<Long> workIds = disLikeRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(DisLike::getWorkId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return workIds
                .stream()
                .map(workRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
