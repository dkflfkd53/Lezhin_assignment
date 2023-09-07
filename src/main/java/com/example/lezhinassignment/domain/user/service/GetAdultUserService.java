package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.entity.QUser;
import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.presentation.dto.response.AdultUserResponse;
import com.example.lezhinassignment.domain.work.entity.QWork;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAdultUserService {

    private final JPAQueryFactory queryFactory;

    public List<AdultUserResponse> getAdultUser() {
        QUser qUser = new QUser("user");
        QWork qWork = new QWork("work");

        List<User> adultUser = queryFactory
                .selectFrom(qUser)
                .join(qUser.AdultWork, qWork)
                .groupBy(qUser)
                .having(qWork.id.countDistinct().goe(3))
                .fetch();

        return adultUser
                .stream()
                .map(AdultUserResponse::new)
                .collect(Collectors.toList());
    }

}
