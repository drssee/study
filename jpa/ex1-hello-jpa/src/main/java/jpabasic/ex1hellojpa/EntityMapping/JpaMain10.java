package jpabasic.ex1hellojpa.EntityMapping;

import jpabasic.ex1hellojpa.domain.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;

public class JpaMain10 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            Member member = em.find(Member.class, 1L);
            //자동 ddl문 실행해서 테이블을 드랍후 다시 만들기때문에 null
            System.out.println("member = "+member);
            member.setName("updatedName2");

            //영속->준영속, 영속성 컨텍스트에서 제외하는 방법들
            em.detach(member);
//            em.clear();
//            em.close();

            Member member1 = em.find(Member.class, 2L);
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
