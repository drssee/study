package jpabasic.ex1hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MemberProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    //member6의 기본키 칼럼값인 member_id를
    //중간테이블 칼럼에 생성후 객체 member와 칼럼 member_id(fk)를 맵핑
    @JoinColumn(name="MEMBER_ID")
    private Member6 member;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product2 product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
