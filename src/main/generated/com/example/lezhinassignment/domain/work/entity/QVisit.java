package com.example.lezhinassignment.domain.work.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = -190547849L;

    public static final QVisit visit = new QVisit("visit");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> workId = createNumber("workId", Long.class);

    public QVisit(String variable) {
        super(Visit.class, forVariable(variable));
    }

    public QVisit(Path<? extends Visit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVisit(PathMetadata metadata) {
        super(Visit.class, metadata);
    }

}

