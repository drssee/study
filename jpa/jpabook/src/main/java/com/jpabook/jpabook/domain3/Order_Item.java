package com.jpabook.jpabook.domain3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Order_Item {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Orders3 order3;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item3 item3;

    private Integer orderPrice;

    private Integer count;
}
