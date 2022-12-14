package com.jpabook.jpabook.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item2 {

    @Id
    @Column(name="ITEM2_ID")
    @GeneratedValue
    private Long id;

    private Integer price;

    private Integer stockQuantity;
}
