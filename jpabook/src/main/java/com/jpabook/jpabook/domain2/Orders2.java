package com.jpabook.jpabook.domain2;

import com.jpabook.jpabook.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders2 {
    @Id
    @Column(name="ORDER2_ID")
    @GeneratedValue
    private Long id;

    //N,FK,관계의주인
    @ManyToOne
    @JoinColumn(name="MEMBER2_ID")
    private Member2 member2;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order_id")
    private List<OrderItem2> orderItems;
}
