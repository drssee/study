package org.zerock.api01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.zerock.api01.domain.Todo;
import org.zerock.api01.dto.PageRequestDTO;
import org.zerock.api01.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {
        List<Todo> todos = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(i -> {
            Todo todo = Todo.builder()
                    .title("Todo..."+i)
                    .dueDate(LocalDate.of(2022, (i%12)+1, (i%30)+1))
                    .writer("user"+(i%10))
                    .complete(false)
                    .build();

            todos.add(todo);
        });
        todoRepository.saveAll(todos);
    }

    @Test
    public void testSearch() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .from(LocalDate.of(2022,10,01))
                .to(LocalDate.of(2023,12,31))
                .build();

        Page<TodoDTO> result = todoRepository.list(pageRequestDTO);
        result.forEach(log::info);
    }
}
