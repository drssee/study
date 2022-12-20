package com.jpabook.jpabook.domain3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category_Item3 {
    @Id
    @GeneratedValue
    @Column(name="CATEGORY_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category3 category3;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item3 item3;
}
