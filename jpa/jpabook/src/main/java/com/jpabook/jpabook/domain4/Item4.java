package com.jpabook.jpabook.domain4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
@Setter
public abstract class Item4 extends BaseEntity4{
    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;
}
