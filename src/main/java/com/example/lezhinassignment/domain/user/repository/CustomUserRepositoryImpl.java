package com.example.lezhinassignment.domain.user.repository;

import com.example.lezhinassignment.domain.work.entity.Visit;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhinassignment.domain.work.entity.QVisit.visit;
import static com.example.lezhinassignment.domain.work.entity.QWork.work;

@RequiredArgsConstructor
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    public List<Visit> getAdultUser() {
        return queryFactory
                .selectFrom(visit)
                .join(visit.work, work)
                .groupBy(visit)
                .having(work.countDistinct().goe(3))
                .fetch();
    }
}
