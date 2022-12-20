package com.jpabook.jpabook.domain3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member3 {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    //읽기전용 멤버변수
    @OneToMany(mappedBy = "member3")
    private List<Orders3> orders = new ArrayList<>();
}
