package jpabasic.ex1hellojpa.RelationMapping;

import jpabasic.ex1hellojpa.Member2;
import jpabasic.ex1hellojpa.Member3;
import jpabasic.ex1hellojpa.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain14 {
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
            //기본키가 생성된 후 영속화 되기때문에 기본키 호출 가능
//            member.setTeamId(team.getId());
            em.persist(member);

            //객체지향 스럽지 못하다(객체 참조 그래프 불가능)
            Member3 findMember = em.find(Member3.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);


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
