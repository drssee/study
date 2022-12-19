package jpabasic.ex1hellojpa.RelationMapping;

import jpabasic.ex1hellojpa.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain19 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //N:N을 1:N N:1로 풀어냄

            Member6 member6 = new Member6();
            member6.setUsername("member1");
            Product2 product2 = new Product2();
            product2.setName("product1");

            //풀어낸 중간테이블
            MemberProduct memberProduct = new MemberProduct();
            memberProduct.setMember(member6);
            memberProduct.setProduct(product2);

            em.persist(member6);
            em.persist(product2);
            em.persist(memberProduct);

            em.flush();
            em.clear();

            MemberProduct memberProduct1 = em.find(MemberProduct.class, 3L);
            System.out.println("memberProduct1 = " + memberProduct1);

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
