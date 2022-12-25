package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member3;
import jpabasic.ex1hellojpa.domain.member.Member8;
import jpabasic.ex1hellojpa.domain.team.Team;
import jpabasic.ex1hellojpa.domain.team.Team4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain30 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //Eager는 member3 조회시 team도 한번에 가져옴
            Team4 team = new Team4();
            team.setName("TeamA");
            em.persist(team);

            Team4 team2 = new Team4();
            team.setName("TeamB");
            em.persist(team2);

            Member8 member = new Member8();
            member.setUsername("memberA");
            member.setTeam(team);
            em.persist(member);

            Member8 member2 = new Member8();
            member.setUsername("memberB");
            member.setTeam(team2);
            em.persist(member2);

            //Eager 즉시조회
//            em.find(Member8.class,member.getId());

            //Jpql N+1 (em.find X)
            //Jpql은 영속성 컨텍스트 이용하는 em이 아니라
            //바로 쿼리문을 날림
            //select * from member;
            List<Member8> members = em.createQuery("select m from Member8 m",Member8.class).getResultList();
            //이후 멤버 테이블이 가지고 있는 FK이자
            //멤버가 의존하는 Team과의 관계에 Eager가 걸려있어
            //조회한 모든 리스트 N개의 Team엔티티를 조회하는 쿼리가 날라감
            //그러므로 1+N개의 쿼리가 생성되게됨
            //해결법 : Lazy전략으로 변경후 한번에 가져오길 원하는 곳만 fetch join 이용

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
