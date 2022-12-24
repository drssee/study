package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.composite_key.DoubleFK;
import jpabasic.ex1hellojpa.domain.composite_key.DoublePK;
import jpabasic.ex1hellojpa.domain.member.Member5;
import jpabasic.ex1hellojpa.domain.member.Member7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain23 {
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

            //jpa가 한번에 모든 데이터를 가져옴
//            Member5 findMember5_1 = em.find(Member5.class, member5.getId());
//            System.out.println("findMember5_1.get = " + findMember5_1.getId());
//            System.out.println("findMember5_1.getUsername() = " + findMember5_1.getUsername());

            //jpa가 가짜(proxy) 클래스 객체를 만들어두고
            // 데이터를 실제 사용할때 쿼리를 날림
            Member5 findMember5_2 = em.getReference(Member5.class, member5.getId());
            System.out.println("findMember5_2(proxy) = " + findMember5_2.getClass());
            //프린트할때 DB의 데이터가 필요하니 쿼리문을 날려 가져옴
            System.out.println("findMember5_2.getId() = " + findMember5_2.getId());
            System.out.println("findMember5_2.getUsername() = " + findMember5_2.getUsername());
            //두번째 요청시 프록시객체에 DB에서 가져온 타겟 엔티티 참조값이 맵핑되어
            //DB 조회없이 가져올수 있다
            System.out.println("findMember5_2.getId() = " + findMember5_2.getId());
            System.out.println("findMember5_2.getUsername() = " + findMember5_2.getUsername());

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
