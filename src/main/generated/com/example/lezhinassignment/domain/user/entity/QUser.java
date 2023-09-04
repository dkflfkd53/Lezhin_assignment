package com.example.lezhinassignment.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 341215449L;

    public static final QUser user = new QUser("user");

    public final ListPath<com.example.lezhinassignment.domain.work.entity.Work, com.example.lezhinassignment.domain.work.entity.QWork> AdultWork = this.<com.example.lezhinassignment.domain.work.entity.Work, com.example.lezhinassignment.domain.work.entity.QWork>createList("AdultWork", com.example.lezhinassignment.domain.work.entity.Work.class, com.example.lezhinassignment.domain.work.entity.QWork.class, PathInits.DIRECT2);

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath type = createString("type");

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userName = createString("userName");

    public final DateTimePath<java.time.LocalDateTime> visitTime = createDateTime("visitTime", java.time.LocalDateTime.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

