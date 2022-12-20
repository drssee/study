package com.jpabook.jpabook.domain3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category3 {
    @Id
    @GeneratedValue
    @Column(name="CATEGORY_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category3")
    private List<Category_Item3> category_item3s = new ArrayList<>();
}
