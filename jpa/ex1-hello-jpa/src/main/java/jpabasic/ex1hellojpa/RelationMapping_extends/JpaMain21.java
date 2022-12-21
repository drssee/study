package jpabasic.ex1hellojpa.RelationMapping_extends;

import jpabasic.ex1hellojpa.domain.member.Member7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain21 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //JPA 공통칼럼 @MappedSuperclass 전략
            //1.상속관계 매핑X
            //2.엔티티X -> 테이블과 매핑X
            //3.자식클래스에 칼럼 매핑정보만 제공

            Member7 member7 = new Member7() ;
            member7.setUsername("user1");
            member7.setLastModifiedBy("Kim");
            member7.setCreatedDate(LocalDateTime.now());

            em.persist(member7);

            em.flush();
            em.clear();

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
