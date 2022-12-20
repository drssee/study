package com.jpabook.jpabook.domain3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Item3 {
    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;
}
