package com.jpabook.jpabook.domain4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Album4 extends Item4{
    private String artist;

    private String etc;
}
