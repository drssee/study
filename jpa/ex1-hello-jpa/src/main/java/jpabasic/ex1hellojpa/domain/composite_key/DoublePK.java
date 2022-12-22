package jpabasic.ex1hellojpa.domain.composite_key;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// 기본키가 2개 이상일시 == 으로 기본키 값의 중복을 비교할 수 없기 때문에
// 객체의 멤버변수들 비교를 위한 해시코드,이퀄스를 오버라이딩한, 별도의 객체가 필요함
// (Hash,Equals는 전체 멤버변수들을 기준으로 같은 객체인지 판단하기 위함)
// (Comparable은 별도의 정렬 기준을 위한 특정 멤버변수 비교)
@IdClass(CompositeKey.class)
@Getter
@Setter
public class DoublePK {
    @Id
    @Column(name="DOUBLE_PK_ID1")
    private String pk1;

    @Id
    @Column(name="DOUBLE_PK_ID2")
    private String pk2;

    private String name1;

    @OneToMany(mappedBy = "doublePK")
    private List<DoubleFK> doubleFKList = new ArrayList<>();
}
