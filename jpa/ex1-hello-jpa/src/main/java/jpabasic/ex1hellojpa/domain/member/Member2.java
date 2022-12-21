package jpabasic.ex1hellojpa.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

//jpa가 제공하는 시퀀스 전략
//1
@SequenceGenerator(
        name="member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1,
        //db의 member_seq 시퀀스에서 미리 50개의 pk값을 가져와 최적화
        allocationSize = 50
)

//2
//@TableGenerator(
//        name="member_seq_generator",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ" , allocationSize = 1
//)

public class Member2 {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")

    //identity 전략에서는 pk값을 db에 insert후 알게 되기 때문에
    //em.persist후 바로 insert 쿼리를 날림
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    private Long id;

    @Column(name="name")
    private String username;

    public Member2(){}
}
