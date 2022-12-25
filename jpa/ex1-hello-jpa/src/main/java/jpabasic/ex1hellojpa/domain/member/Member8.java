package jpabasic.ex1hellojpa.domain.member;

import jpabasic.ex1hellojpa.domain.team.Team;
import jpabasic.ex1hellojpa.domain.team.Team4;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member8 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
//    @Column(name = "TEAM_ID")
//    private Long teamId;


    //oop의 객체Team과 RDB의 칼럼TEAM_ID를 jpa가 맵핑해줌
    //***** 외래키가 있는 테이블을 관계의 주인으로 설정 *****
    //***** N:1 -> N쪽이 연관관계 주인 *****
    // 멤버(클래스)입장에서 팀(jpa칼럼)과의 관계(N:1)
    @ManyToOne(fetch = FetchType.EAGER) //Eager는 즉시조회
    @JoinColumn(name = "TEAM_ID")
    private Team4 team;

    //연관관계 편의 메서드
    public void setTeam(Team4 team) {
        this.team = team;
        //관계의 주인 세팅시 mappedby쪽 메모리에도 저장
        team.getMembers().add(this);
    }
}
