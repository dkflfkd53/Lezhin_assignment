package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.Work;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhinassignment.domain.work.entity.QDisLike.disLike;
import static com.example.lezhinassignment.domain.work.entity.QLike.like;
import static com.example.lezhinassignment.domain.work.entity.QWork.work;

@RequiredArgsConstructor
@Repository
public class CustomWorkRepositoryImpl implements CustomWorkRepository {

    private final JPAQueryFactory queryFactory;

    public List<Work> findByLikes() {
        return queryFactory
                .selectFrom(work)
                .leftJoin(work.disLikes, disLike)
                .groupBy(work)
                .orderBy(disLike.count().desc())
                .limit(3)
                .fetch();
    }

    public List<Work> findByDisLikes() {
        return queryFactory
                .selectFrom(work)
                .leftJoin(work.likes, like)
                .groupBy(work)
                .orderBy(like.count().desc())
                .limit(3)
                .fetch();
    }

}
