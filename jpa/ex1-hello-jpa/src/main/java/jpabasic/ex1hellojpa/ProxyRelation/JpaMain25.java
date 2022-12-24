package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain25 {
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

            //영속성 컨텍스트에 엔티티 저장
            Member5 m1 = em.find(Member5.class,member5.getId());

            //영속성 컨텍스트에 저장된 엔티티를 em.getReference()를 하면
            // 프록시 객체를 만들고 DB에 새로 조회를 할지? X
            // (이미 있는데 굳이? 프록시를 만들 필요가 있나)
            // (== 유지 위해, 같은 객체면 같은 참조값 객체)
            // 영속성 컨텍스트의 캐시값에서 찾아올지? O
            Member5 m2 = em.getReference(Member5.class,member5.getId());

            System.out.println("m2.getClass() = " + m2.getClass());

            //이값은 항상 true여야함 (같은 tx에 속하면 get,조회시 자바 컬렉션처럼 항상 같은 객체이어야함)
            System.out.println("m1 == m2 "+(m1==m2));

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
