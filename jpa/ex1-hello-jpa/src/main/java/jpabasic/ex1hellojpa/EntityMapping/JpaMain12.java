package jpabasic.ex1hellojpa.EntityMapping;

import jpabasic.ex1hellojpa.domain.member.Member2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain12{
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member2 member2 = new Member2();
            member2.setUsername("C");

            System.out.println("==persist==");
            em.persist(member2);
            System.out.println("member2.id = "+member2.getId());
            System.out.println("==persist==");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
