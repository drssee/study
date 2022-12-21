package jpabasic.ex1hellojpa.RelationMapping_extends;

import jpabasic.ex1hellojpa.domain.MemberProduct;
import jpabasic.ex1hellojpa.domain.items.Movie;
import jpabasic.ex1hellojpa.domain.member.Member6;
import jpabasic.ex1hellojpa.domain.product.Product2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain20 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //JPA 상속관계 매핑 기본전략은 싱글테이블 전략

            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            System.out.println("===================");
            System.out.println("pk = "+movie.getId());
            System.out.println("===================");

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());

            System.out.println(findMovie.getName());

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
