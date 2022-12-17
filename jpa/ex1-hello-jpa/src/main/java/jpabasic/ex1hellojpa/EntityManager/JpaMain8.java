package jpabasic.ex1hellojpa.EntityManager;

import jpabasic.ex1hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain8 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            Member member = new Member(200L,"member200");
            //영속성 1차 캐시에 저장 + 쓰기지연 SQL 저장소에 저장됨
            em.persist(member);

            //커밋전에 강제로 미리 flush
            //*flush는 영속성 컨텍스트를 비우는것이 아님, 쓰기지연 SQL 저장소의 쿼리를 flush 하는것
            //1차 캐시는 유지
            em.flush();

            System.out.println("==================flush후================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
