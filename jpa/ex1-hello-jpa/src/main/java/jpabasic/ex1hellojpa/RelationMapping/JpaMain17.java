package jpabasic.ex1hellojpa.RelationMapping;

import jpabasic.ex1hellojpa.domain.member.Member3;
import jpabasic.ex1hellojpa.domain.team.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain17 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //Member N : Team 1
            //N인 Member가 관계의 주인
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member3 member3 = new Member3();
            member3.setUsername("UserA");
            member3.setTeam(team);
            em.persist(member3);

            //순수 객체 상태를 위해 mappedby쪽 컬렉션 메모리에 memeber 저장
//            team.getMembers().add(member3);

//            em.flush();
//            em.clear();

            System.out.println("======================");
            //mappedby된 members가 실제 사용될때 select 쿼리 생성(지연 로딩)
            List<Member3> members = em.find(Team.class,1L).getMembers();
            for (Member3 member : members) {
                System.out.println("member = "+member.getUsername());
            }
            System.out.println("======================");

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
