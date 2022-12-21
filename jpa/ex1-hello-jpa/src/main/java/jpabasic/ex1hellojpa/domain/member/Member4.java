package jpabasic.ex1hellojpa.domain.member;

import jpabasic.ex1hellojpa.domain.Locker;
import jpabasic.ex1hellojpa.domain.team.Team2;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member4 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false, updatable = false)
    private Team2 team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID", unique = true) //1:1 이라 유니크 제약조건 추가
    //1:1 관계일시 자신 테이블의 FK(LOCKER_ID )는 자신이 관리해야함
    //1:1 관계시 자주 사용되는 테이블이 주테이블, FK 존재
    private Locker locker;
}
