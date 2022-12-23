package com.jpabook.jpabook.domain3;

import com.jpabook.jpabook.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Orders3 {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member3 member3;

    @OneToOne
    @JoinColumn(name="DELIVERY_ID")
    private Delivery3 delivery3;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //양방향 연관관계 편의 메서드
    public void createOrders(Member3 member3,Delivery3 delivery3){
        this.member3 = member3;
        member3.getOrders().add(this);

        this.delivery3 = delivery3;
        delivery3.setOrders3(this);
    }
}
