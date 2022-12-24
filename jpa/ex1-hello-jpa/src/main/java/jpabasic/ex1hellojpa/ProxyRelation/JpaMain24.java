package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain24 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //프록시

            Member5 member5 = new Member5();
            member5.setUsername("hello");

            Member5 member5_2 = new Member5();
            member5_2.setUsername("hello");

            em.persist(member5);
            em.persist(member5_2);

            em.flush();
            em.clear();

            Member5 m1 = em.find(Member5.class,member5.getId());
            Member5 m2 = em.getReference(Member5.class,member5_2.getId());

            //애초에 m1과 m2는 서로 다른 객체(서로다른 row,entity)를 가져온 것이라
            //m1==m2 는 false 일수밖에 없음
            //같은 클래스라는 것을 증명하려면
            // m1 instanceof Member5 && m2 instanceof Member5

//            System.out.println("m1 == m2: "+(m1.getClass()==m2.getClass()));
            System.out.println("m1 instanceof Member5: "+(m1 instanceof Member5));
            System.out.println("m2 instanceof Member5: "+(m2 instanceof Member5));

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
