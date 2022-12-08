package jpabasic.ex1hellojpa.EntityMapping;

import jpabasic.ex1hellojpa.Member;
import jpabasic.ex1hellojpa.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;

public class JpaMain11 {
    public static void main(String[] args) {
        //persistence->entitymanagerfactory->entitymanager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //로직
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("A");
            member.setRoleType(RoleType.USER);

//            Member member2 = new Member();
//            member.setId(2L);
//            member.setName("B");
//            member.setRoleType(RoleType.ADMIN);

            em.persist(member);
//            em.persist(member2);

            System.out.println("member = "+em.find(Member.class,1L));
//            System.out.println("member2 = "+em.find(Member.class,2L));

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
