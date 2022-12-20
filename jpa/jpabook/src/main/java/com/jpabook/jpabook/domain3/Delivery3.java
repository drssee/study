package com.jpabook.jpabook.domain3;

import com.jpabook.jpabook.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery3 {
    @Id
    @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(mappedBy = "delivery3")
    private Orders3 orders3;
}
