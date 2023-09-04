package com.example.lezhinassignment.domain.work.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWork is a Querydsl query type for Work
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWork extends EntityPathBase<Work> {

    private static final long serialVersionUID = 1656456805L;

    public static final QWork work = new QWork("work");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath title = createString("title");

    public final EnumPath<com.example.lezhinassignment.domain.work.enums.WorkType> workType = createEnum("workType", com.example.lezhinassignment.domain.work.enums.WorkType.class);

    public QWork(String variable) {
        super(Work.class, forVariable(variable));
    }

    public QWork(Path<? extends Work> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWork(PathMetadata metadata) {
        super(Work.class, metadata);
    }

}

