package jpabasic.ex1hellojpa.domain.composite_key;

import jpabasic.ex1hellojpa.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DoubleFK extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="DOUBLE_FK_ID")
    private Long id;

    @ManyToOne
    @JoinColumns({
            //doublefk 테이블에 name의값인 컬럼명 이름으로 넣는데
            //referencedcolumnname을 참조해 그 칼럼값을
            //doublefk 테이블의 name의값인 칼럼명 이름에 저장
            @JoinColumn(name="DOUBLE_PK_ID1",referencedColumnName = "DOUBLE_PK_ID1"),
            @JoinColumn(name="DOUBLE_PK_ID2",referencedColumnName = "DOUBLE_PK_ID2")
    })
    private DoublePK doublePK;

    private String name2;
}
