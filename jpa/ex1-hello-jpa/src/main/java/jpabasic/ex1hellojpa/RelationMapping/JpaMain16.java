package jpabasic.ex1hellojpa.RelationMapping;

import jpabasic.ex1hellojpa.domain.member.Member3;
import jpabasic.ex1hellojpa.domain.team.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain16 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member3 member = new Member3();
            member.setUsername("member1");
            //맵핑을 jpa이용 수정해서 패러다임 불일치 해결함
            member.setTeam(team);

            em.persist(member);

//            //영속성컨텍스트의 1차캐시에서 가져오는것이 아닌
//            //직접 쿼리문을 날리고 싶을때
            em.flush();
            em.clear();

            //객체지향 그래프 탐색
            Member3 findMember = em.find(Member3.class, member.getId());
            Team findTeam = findMember.getTeam();
            List<Member3> members = findTeam.getMembers();
            for (Member3 member1 : members) {
                System.out.println("member = "+member1.getUsername());
            }

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
