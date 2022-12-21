package jpabasic.ex1hellojpa.domain.team;

import jpabasic.ex1hellojpa.domain.common.BaseEntity;
import jpabasic.ex1hellojpa.domain.member.Member4;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team3 extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="TEAM_ID")
    private List<Member4> members = new ArrayList<>();
}
