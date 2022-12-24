package jpabasic.ex1hellojpa.ProxyRelation;

import jpabasic.ex1hellojpa.domain.member.Member5;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain28 {
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

            //proxyUtil
            //초기화전
            System.out.println("proxy 초기화전 "+emf.getPersistenceUnitUtil().isLoaded(reference));

            //초기화후
            Hibernate.initialize(reference);//강제초기화
            System.out.println("proxy 초기화후 "+emf.getPersistenceUnitUtil().isLoaded(reference));


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
