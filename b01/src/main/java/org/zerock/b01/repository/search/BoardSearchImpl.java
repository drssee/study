package org.zerock.b01.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;

import java.util.List;

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

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }
}
