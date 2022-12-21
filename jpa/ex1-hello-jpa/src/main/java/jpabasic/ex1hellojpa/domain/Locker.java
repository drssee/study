package jpabasic.ex1hellojpa.domain;

import jpabasic.ex1hellojpa.domain.member.Member4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member4 member4;
}
