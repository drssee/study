package com.jpabook.jpabook;

import com.jpabook.jpabook.domain.Member;
import com.jpabook.jpabook.domain.Order;
import com.jpabook.jpabook.domain2.OrderItem2;
import com.jpabook.jpabook.domain2.Orders2;
import com.jpabook.jpabook.domain4.Book4;

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
            Orders2 orders2 = new Orders2();
            OrderItem2 orderItem2 = new OrderItem2();

            //객체 연관관계 편의 메서드(양방향 커스텀)
            orders2.setOrderItems(orderItem2);

            em.persist(orderItem2);
            em.persist(orders2);

            Long id = orders2.getId();
            System.out.println("id = " + id);

            em.flush();
            em.clear();

            Orders2 findOrders2 = em.find(Orders2.class, id);
            System.out.println("orders21.getOrderItems() = " + findOrders2.getOrderItems());
            System.out.println("======== 예제2 =========");

            System.out.println("======== 예제3 =========");

            System.out.println("======== 예제3 =========");

            System.out.println("======== 예제4 =========");

            Book4 book4 = new Book4();
            book4.setName("JPA");
            book4.setAuthor("저자");

            em.persist(book4);

            System.out.println("======== 예제4 =========");

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
