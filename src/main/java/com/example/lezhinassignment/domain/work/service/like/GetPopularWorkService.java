package com.example.lezhinassignment.domain.work.service.like;

import com.example.lezhinassignment.domain.work.entity.QLike;
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
public class GetPopularWorkService {

    private final JPAQueryFactory queryFactory;

    public List<WorkResponse> getPopularWork() {
        QWork work = new QWork("works");
        QLike like = new QLike("likes");

        List<Work> works = queryFactory
                .selectFrom(work)
                .leftJoin(work.likes, like)
                .groupBy(work)
                .orderBy(like.count().desc())
                .limit(3)
                .fetch();

        return works
                .stream()
                .map(WorkResponse::new)
                .collect(Collectors.toList());
    }

}
