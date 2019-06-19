package com.ha.jpa.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserVO is a Querydsl query type for UserVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserVO extends EntityPathBase<UserVO> {

    private static final long serialVersionUID = 558403326L;

    public static final QUserVO userVO = new QUserVO("userVO");

    public final StringPath username = createString("username");

    public QUserVO(String variable) {
        super(UserVO.class, forVariable(variable));
    }

    public QUserVO(Path<? extends UserVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserVO(PathMetadata metadata) {
        super(UserVO.class, metadata);
    }

}

