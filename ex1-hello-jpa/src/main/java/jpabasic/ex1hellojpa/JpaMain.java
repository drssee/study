package jpabasic.ex1hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            //업데이트

            //jpa를 통해 가져온 객체는
            //변경시 tx.commit(); 직전 변경사항을 체크해 업데이트 쿼리 생성

            Member member = em.find(Member.class, 1L);
            member.setName("HelloJPA");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
