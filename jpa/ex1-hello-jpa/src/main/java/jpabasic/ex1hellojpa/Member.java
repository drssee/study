package jpabasic.ex1hellojpa;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "MEMBER")
//@Table(uniqueConstraints = "유니크 제약조건 이름")
public class Member {

    @Id
    private Long id;

    //(updatable=false)변경되도 db에 update되지 않음
    //(nullable=false) notnull
    //(columnDefinition = "varchar(100) default 11") 임의로 정의
    @Column(name="name",updatable = false, nullable = false)
    private String name;

    private Integer age;

    //Ordinal로 사용시 수정이 어려워 String 사용 권장
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //timestamp(날짜+시간)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //자바8이상
    private LocalDate testLocalDate;//연월
    private LocalDateTime testLocalDateTime;//연월일+시간

    //db에 쓸 변수가 아님
    @Transient
    private int temp;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "team_team_id")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Member(Long id,String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Member member = (Member) o;
        return id != null && Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
