package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain27 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //프록시

            Member5 member5 = new Member5();
            member5.setUsername("member1");

            em.persist(member5);

            em.flush();
            em.clear();

            Member5 reference = em.getReference(Member5.class,member5.getId());
            //proxy
            System.out.println("reference = "+reference.getClass());

            //프록시 조회전에 영속성 컨텍스트를 종료하거나
//            em.close();
            //프록시객체를 영속성 컨텍스트 관리 밖으로 빼내면 즉 준영속상태일 경우
            em.detach(reference);

            //proxy 타겟 초기화를 위한 데이터 사용
            reference.getUsername(); //could not initialize proxy,exception 발생
            //이 경우를 피하려면 트렌젝션과 영속성컨텍스트 생명주기를 맞춰야함

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
