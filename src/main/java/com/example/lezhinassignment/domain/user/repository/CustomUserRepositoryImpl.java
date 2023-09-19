package com.example.lezhinassignment.domain.user.repository;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.work.enums.WorkType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhinassignment.domain.user.entity.QUser.user;
import static com.example.lezhinassignment.domain.work.entity.QVisit.visit;
import static com.example.lezhinassignment.domain.work.entity.QWork.work;

@RequiredArgsConstructor
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    public List<User> getAdultUser() {
        /*return queryFactory.select(user)
                .join(visit).on(user.id.eq(visit.user.id))
                .join(work).on(visit.work.id.eq(work.id).and(work.workType.eq(WorkType.ADULT)))
                .groupBy(user)
                .having(visit.count().gt(3))
                .fetch();*/

        return queryFactory.selectFrom(user)
                .join(visit).on(user.id.eq(visit.user.id))
                .join(work).on(visit.work.id.eq(work.id))
                .on(work.workType.eq(WorkType.ADULT))
                .groupBy(user.id, work.id)
                .having(work.count().gt(3))
                .fetch();
    }
}



