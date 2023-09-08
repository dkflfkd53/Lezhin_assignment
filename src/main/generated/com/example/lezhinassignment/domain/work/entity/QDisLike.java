package com.example.lezhinassignment.domain.work.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisLike is a Querydsl query type for DisLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisLike extends EntityPathBase<DisLike> {

    private static final long serialVersionUID = -1523924623L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisLike disLike = new QDisLike("disLike");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.lezhinassignment.domain.user.entity.QUser user;

    public final QWork work;

    public QDisLike(String variable) {
        this(DisLike.class, forVariable(variable), INITS);
    }

    public QDisLike(Path<? extends DisLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisLike(PathMetadata metadata, PathInits inits) {
        this(DisLike.class, metadata, inits);
    }

    public QDisLike(Class<? extends DisLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.lezhinassignment.domain.user.entity.QUser(forProperty("user")) : null;
        this.work = inits.isInitialized("work") ? new QWork(forProperty("work")) : null;
    }

}

