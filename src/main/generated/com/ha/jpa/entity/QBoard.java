package com.ha.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -1723889514L;

    public static final QBoard board = new QBoard("board");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<byte[], Byte> lobByte = createArray("lobByte", byte[].class);

    public final StringPath lobString = createString("lobString");

    public final EnumPath<Board.BOARDTYPE> type = createEnum("type", Board.BOARDTYPE.class);

    public final EnumPath<Board.BOARDTYPE> value = createEnum("value", Board.BOARDTYPE.class);

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

