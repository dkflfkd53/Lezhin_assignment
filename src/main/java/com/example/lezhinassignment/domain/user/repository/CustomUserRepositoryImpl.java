package com.example.lezhinassignment.domain.user.repository;

import com.example.lezhinassignment.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.lezhinassignment.domain.user.entity.QUser.user;
import static com.example.lezhinassignment.domain.work.entity.QWork.work;

@RequiredArgsConstructor
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    public List<User> getAdultUser() {
        return queryFactory
                .selectFrom(user)
                .join(user.AdultWork, work)
                .groupBy(user)
                .having(work.id.countDistinct().goe(3))
                .fetch();
    }
}
