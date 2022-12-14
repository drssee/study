package com.jpabook.jpabook;

import com.jpabook.jpabook.domain.Member;
import com.jpabook.jpabook.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("======== 예제1 =========");
            Order order = em.find(Order.class, 1L);
            Member member = null;
            if(order!=null){
                member = em.find(Member.class, order.getMemberId());
            }
            System.out.println(member);
            System.out.println("======== 예제1 =========");

            System.out.println();

            System.out.println("======== 예제2 =========");

            System.out.println("======== 예제2 =========");
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
