package jpabasic.ex1hellojpa.EntityManager;

import jpabasic.ex1hellojpa.domain.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain5 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            //처음은 db에서 조회
            Member member1 = em.find(Member.class, 100L);
            System.out.println("member1 = " + member1);

            //영속 컨텍스트 1차 캐시에서 조회
            Member member2 = em.find(Member.class, 100L);
            System.out.println("member2 = " + member2);

            //영속컨텍스트 캐시에 저장된 같은 객체
            System.out.println(member1==member2);

            //커밋시 db에 저장
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
