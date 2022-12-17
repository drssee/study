package jpabasic.ex1hellojpa.RelationMapping;

import jpabasic.ex1hellojpa.Member3;
import jpabasic.ex1hellojpa.Member4;
import jpabasic.ex1hellojpa.Team;
import jpabasic.ex1hellojpa.Team2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain18 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //1:N 1쪽을 연관관계 주인으로 할때(거의 없음)

            Member4 member = new Member4();
            member.setUsername("member1");

            em.persist(member);

            Team2 team = new Team2();
            team.setName("teamA");
            //객체의 연관관계 + 테이블의 FK 매핑
            team.getMembers().add(member);

            em.persist(team);

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
