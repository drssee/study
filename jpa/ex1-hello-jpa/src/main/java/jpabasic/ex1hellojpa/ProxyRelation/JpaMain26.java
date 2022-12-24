package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain26 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //프록시

            Member5 member5 = new Member5();
            member5.setUsername("hello");

            em.persist(member5);

            em.flush();
            em.clear();

            //proxy
            Member5 reference = em.getReference(Member5.class,member5.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            //Member5 find
            Member5 findMember = em.find(Member5.class,member5.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass());

            //JPA는 같은 member5 객체인(클래스x)
            //reference,findMember의 == (같은 참조값의 객체) 유지를 위해
            // 자바의 컬렉션 처럼, 같은 객체라는 것을 보장하기 위해
            //실제 member5 객체가 아닌 프록시 객체를 할당한다
            System.out.println(reference == findMember);

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
