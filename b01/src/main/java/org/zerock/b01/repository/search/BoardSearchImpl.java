package org.zerock.b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;
import org.zerock.b01.domain.QReply;
import org.zerock.b01.dto.BoardListAllDTO;
import org.zerock.b01.dto.BoardListReplyCountDTO;

import java.util.List;
import java.util.stream.Collectors;

//QueryDsl은 코드를 이용해 JPQL(jpa용 쿼리문)을 만들어준다
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {

        //QueryDsl과 연결뒤 사용하는
        //Q<T>도메인 클래스가 JPQL(jpa용 쿼리문) 쿼리를 생성해줌
        QBoard qBoard = QBoard.board; //Q도메인 객체

        JPQLQuery<Board> query = from(qBoard); //select * from qBoard

        query.where(qBoard.title.contains("1")); // where title like

        //queryDsl의 paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }

    @Override
    public Page<Board> search2(Pageable pageable) {
        QBoard qBoard = QBoard.board;
        JPQLQuery<Board> query = from(qBoard);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(qBoard.title.contains("11"));
        booleanBuilder.or(qBoard.content.contains("11"));

        query.where(booleanBuilder);
        query.where(qBoard.bno.gt(0L));

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        //types[t,c,w] [제목,내용,작성자]

        QBoard qBoard = QBoard.board;
        JPQLQuery<Board> query = from(qBoard);

        if((types != null && types.length >0) && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(qBoard.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(qBoard.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(qBoard.writer.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }

        query.where(qBoard.bno.gt(0L));

        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable) {
        QBoard qBoard = QBoard.board;
        QReply qReply = QReply.reply;

        JPQLQuery<Board> query = from(qBoard);
        query.leftJoin(qReply).on(qReply.board.eq(qBoard));
        query.groupBy(qBoard);

        if ((types != null && types.length > 0) && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for(String type: types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(qBoard.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(qBoard.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(qBoard.writer.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }
        query.where(qBoard.bno.gt(0L));

        JPQLQuery<BoardListReplyCountDTO> dtoQuery = query.select(Projections.bean(
                BoardListReplyCountDTO.class,
                qBoard.bno,
                qBoard.title,
                qBoard.writer,
                qBoard.regDate,
                qReply.count().as("replyCount")
        ));

        this.getQuerydsl().applyPagination(pageable, dtoQuery);
        List<BoardListReplyCountDTO> dtoList = dtoQuery.fetch();
        long count = dtoQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);
    }

    @Override
    public Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable) {
        QBoard qBoard = QBoard.board;
        QReply qReply = QReply.reply;

        JPQLQuery<Board> boardJPQLQuery = from(qBoard);
        boardJPQLQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));

        boardJPQLQuery.groupBy(qBoard);

        getQuerydsl().applyPagination(pageable, boardJPQLQuery);

        JPQLQuery<Tuple> tupleJPQLQuery = boardJPQLQuery.select(qBoard, qReply.countDistinct());

        List<Tuple> tupleList = tupleJPQLQuery.fetch();

        List<BoardListAllDTO> dtoList = tupleList.stream().map(tuple -> {
            Board board1 = tuple.get(qBoard);
            long replyCount = tuple.get(1,Long.class);

            BoardListAllDTO dto = BoardListAllDTO.builder()
                    .bno(board1.getBno())
                    .title(board1.getTitle())
                    .writer(board1.getWriter())
                    .regDate(board1.getRegDate())
                    .replyCount(replyCount)
                    .build();

            return dto;
        }).collect(Collectors.toList());

        long totalCount = boardJPQLQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, totalCount);
    }
}
