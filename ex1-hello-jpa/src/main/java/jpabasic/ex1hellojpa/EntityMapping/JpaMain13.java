package jpabasic.ex1hellojpa.EntityMapping;

import jpabasic.ex1hellojpa.Member2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain13 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member2 member1 = new Member2();
            member1.setUsername("A");

            Member2 member2 = new Member2();
            member1.setUsername("B");

            Member2 member3 = new Member2();
            member1.setUsername("C");

            System.out.println("=========");

            em.persist(member1); //시퀀스 호출 1,51
            System.out.println("member1 = " + member1.getId());
            em.persist(member2); //MEM
            System.out.println("member2 = " + member2.getId());
            em.persist(member3); //MEM
            System.out.println("member3 = " + member3.getId());

            System.out.println("=========");

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
