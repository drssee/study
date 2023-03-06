package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Board;
import org.zerock.b01.repository.search.BoardSearch;

//Spring Data Jpa 인터페이스와 연결을 하고, QueryDsl과 연동한 BoardSearch(Impl)를 추가
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
}
