package org.zerock.api01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.api01.domain.QTodo;
import org.zerock.api01.domain.Todo;
import org.zerock.api01.dto.PageRequestDTO;
import org.zerock.api01.dto.TodoDTO;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    //도메인 객체를 querydsl에 전달
    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        QTodo todo = QTodo.todo;
        JPQLQuery<Todo> query = from(todo);

        if (pageRequestDTO.getFrom() != null && pageRequestDTO.getTo() != null) {

            BooleanBuilder fromToBuilder = new BooleanBuilder();
            fromToBuilder.and(todo.dueDate.goe(pageRequestDTO.getFrom()));
            fromToBuilder.and(todo.dueDate.loe(pageRequestDTO.getTo()));
            query.where(fromToBuilder);
        }

        if (pageRequestDTO.getComplete() != null) {
            query.where(todo.complete.eq(pageRequestDTO.getComplete()));
        }

        if (pageRequestDTO.getKeyword() != null) {
            query.where(todo.title.contains(pageRequestDTO.getKeyword()));
        }

        this.getQuerydsl().applyPagination(pageRequestDTO.getPageable("tno"), query);

        //위에서 from - where - limit - 하고 이제 select - 차례
        JPQLQuery<TodoDTO> dtoQuery = query.select(Projections.bean(TodoDTO.class,
                todo.tno,
                todo.title,
                todo.dueDate,
                todo.complete,
                todo.writer
        ));

        //만들어진 쿼리 실행
        List<TodoDTO> list = dtoQuery.fetch();
        //전체 갯수 구하는 쿼리 실행
        long count = dtoQuery.fetchCount();

        //페이징시 pagerequestDTO를 이용해 page객체를 만들고 pageresponseDTO를 이용해 반환
        return new PageImpl<>(list, pageRequestDTO.getPageable("tno"), count);
    }
}
