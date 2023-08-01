package com.example.batchcrawler.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaeMinEntity is a Querydsl query type for BaeMinEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBaeMinEntity extends EntityPathBase<BaeMinEntity> {

    private static final long serialVersionUID = 900256823L;

    public static final QBaeMinEntity baeMinEntity = new QBaeMinEntity("baeMinEntity");

    public final StringPath author = createString("author");

    public final StringPath catalogues = createString("catalogues");

    public final StringPath date = createString("date");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath postId = createString("postId");

    public final StringPath summary = createString("summary");

    public final StringPath thumbnailUrl = createString("thumbnailUrl");

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public QBaeMinEntity(String variable) {
        super(BaeMinEntity.class, forVariable(variable));
    }

    public QBaeMinEntity(Path<? extends BaeMinEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaeMinEntity(PathMetadata metadata) {
        super(BaeMinEntity.class, metadata);
    }

}

