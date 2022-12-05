package jpabasic.ex1hellojpa.EntityManager;

import jpabasic.ex1hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain7 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            Member member = em.find(Member.class, 150L);
            //커밋할때 변경내용 있으면 update 실행
            member.setName("updatedName");

            System.out.println("===============================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
