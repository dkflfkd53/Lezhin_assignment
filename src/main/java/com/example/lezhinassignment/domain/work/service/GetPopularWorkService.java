package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.work.entity.Like;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.LikeRepository;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPopularWorkService {

    private final WorkRepository workRepository;
    private final LikeRepository likeRepository;

    public List<Work> getPopularWork() {
        List<Long> workIds = likeRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Like::getWorkId, Collectors.counting()))
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
