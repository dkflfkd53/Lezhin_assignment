package com.example.lezhinassignment.domain.work.service;

import com.example.lezhinassignment.domain.work.entity.QDisLike;
import com.example.lezhinassignment.domain.work.entity.QWork;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.presentation.dto.response.WorkResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUnpopularWorkService {

    private final JPAQueryFactory queryFactory;

    public List<WorkResponse> getUnpopularWork() {
        QWork work = new QWork("works");
        QDisLike disLike = new QDisLike("disLikes");

        List<Work> works =  queryFactory
                .selectFrom(work)
                .leftJoin(work.disLikes, disLike)
                .groupBy(work)
                .orderBy(disLike.count().desc())
                .limit(3)
                .fetch();

        return works
                .stream()
                .map(WorkResponse::new)
                .collect(Collectors.toList());
    }

}
