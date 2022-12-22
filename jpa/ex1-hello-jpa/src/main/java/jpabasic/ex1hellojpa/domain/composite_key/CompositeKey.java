package jpabasic.ex1hellojpa.domain.composite_key;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class CompositeKey implements Serializable {
    private String pk1;
    private String pk2;
    public CompositeKey(){}
    public CompositeKey(String pk1,String pk2){
        this.pk1=pk1;
        this.pk2=pk2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKey)) return false;
        CompositeKey that = (CompositeKey) o;
        return Objects.equals(getPk1(), that.getPk1()) && Objects.equals(getPk2(), that.getPk2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk1(), getPk2());
    }
}
