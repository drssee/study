package org.zerock.b01.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    //시작페이지
    private int start;
    //끝페이지
    private int end;

    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        if (total <= 0) {
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10; // 화면에서 마지막번호
        this.start = this.end - 9;
        int last = (int)(Math.ceil((total/(double)size))); // 마지막 페이지번호
        this.end = Math.min(end, last);
        this.prev = this.start > 1;
        this.next = this.total > this.end * this.size;
    }
}
