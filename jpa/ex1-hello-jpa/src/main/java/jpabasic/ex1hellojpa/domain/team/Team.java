package jpabasic.ex1hellojpa.domain.team;

import jpabasic.ex1hellojpa.domain.member.Member3;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    //mappedBy=관계의 주인이 아니다 , 테이블에 존재하는 칼럼이 아님
    @OneToMany(mappedBy = "team")
    private List<Member3> members = new ArrayList<>();
}
