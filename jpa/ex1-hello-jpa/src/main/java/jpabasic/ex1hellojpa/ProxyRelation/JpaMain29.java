package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member3;
import jpabasic.ex1hellojpa.domain.team.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain29 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Lazy 전략을 사용하면 프록시 객체를 조회함 <-> Eager는 member3 조회시 team도 한번에 가져옴
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member3 member3 = new Member3();
            member3.setUsername("LAZY_MEMBER");
            member3.setTeam(team);
            em.persist(member3);
            System.out.println("Q1.쿼리를 날리기전 영속성 컨텍스트에 저장만 해도 기본키값이 셋팅 되는지 = "+member3.getId());

            em.flush();
            em.clear();

            Member3 findMember = em.find(Member3.class,member3.getId());
            System.out.println(findMember.getTeam().getClass());//Team 프록시객체

            System.out.println("===============조회하는 시점================");
            //Team 프록시객체를 조회시 TeamProxy.target==null(실제team==null) 이면 이시점에 db에서 team을 조회함
            System.out.println(findMember.getTeam().getName());
            System.out.println("===============조회하는 시점================");

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
