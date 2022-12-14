package com.jpabook.jpabook.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Member2 {
    @Id
    @Column(name="MEMBER2_ID")
    @GeneratedValue
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member2")
    private List<Orders2> orders;
}
