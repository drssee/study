package jpabasic.ex1hellojpa.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product2 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
