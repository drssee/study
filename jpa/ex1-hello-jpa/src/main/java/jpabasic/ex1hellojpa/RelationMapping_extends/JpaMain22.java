package jpabasic.ex1hellojpa.RelationMapping_extends;

import jpabasic.ex1hellojpa.domain.composite_key.DoubleFK;
import jpabasic.ex1hellojpa.domain.composite_key.DoublePK;
import jpabasic.ex1hellojpa.domain.member.Member7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain22 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //복합키 생성전략

            DoublePK doublePK = new DoublePK();
            doublePK.setPk1("pk1");
            doublePK.setPk2("pk2");

            DoubleFK doubleFK = new DoubleFK();

            //연관관계 주인 맵핑
            doubleFK.setDoublePK(doublePK);
            //연관관계 상대방 맵핑
            doublePK.getDoubleFKList().add(doubleFK);

            em.persist(doublePK);
            em.persist(doubleFK);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
