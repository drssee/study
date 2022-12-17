package jpabasic.ex1hellojpa.EntityManager;

import jpabasic.ex1hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;

public class JpaMain9 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            Member member = em.find(Member.class, 150L);
            member.setName("updatedName2");

            //영속->준영속, 영속성 컨텍스트에서 제외하는 방법들
            em.detach(member);
//            em.clear();
//            em.close();

            Member member1 = em.find(Member.class, 150L);
            System.out.println("member!=member1, "+(!Objects.equals(member.getName(), member1.getName())));

            //영속->준영속 해서 자동 업데이트 대상 제외 -> 업데이트쿼리x
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
