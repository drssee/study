package com.jpabook.jpabook.domain2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem2 {

    @Id
    @Column(name="ORDER2_ITEM2_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDER2_ID")
    private Orders2 order_id;

    @ManyToOne
    @JoinColumn(name="ITEM2_ID")
    private Item2 item2;

    private Integer orderPrice;

    private Integer count;
}
