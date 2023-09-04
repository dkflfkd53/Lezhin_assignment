package com.example.lezhinassignment.domain.work.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDisLike is a Querydsl query type for DisLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisLike extends EntityPathBase<DisLike> {

    private static final long serialVersionUID = -1523924623L;

    public static final QDisLike disLike = new QDisLike("disLike");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> workId = createNumber("workId", Long.class);

    public QDisLike(String variable) {
        super(DisLike.class, forVariable(variable));
    }

    public QDisLike(Path<? extends DisLike> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDisLike(PathMetadata metadata) {
        super(DisLike.class, metadata);
    }

}

