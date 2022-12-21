package jpabasic.ex1hellojpa.domain.items;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
//@DiscriminatorValue("A") //DTYPE 칼럼 value 지정 어노테이션
public class Album extends Item{
    private String artist;
}
