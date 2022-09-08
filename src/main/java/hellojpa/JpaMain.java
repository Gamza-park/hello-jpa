package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // Insert
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

            // Update
//            Member member = em.find(Member.class, 1L);
//            System.out.println("find member name is : " + member.getName());
//            System.out.println("find member id is   : " + member.getId());
//            member.setName("NameChangeTest");

            // JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name is : " + member.getName());
//            }

            // Non Persist
//            Member member = new Member();
//            member.setId(99L);
//            member.setName("JPA");
//
//            // Persist
//            System.out.println("=====Before=====");
//            em.persist(member);
//            System.out.println("=====After=====");

//            Member findMember1 = em.find(Member.class, 99L);
//            Member findMember2 = em.find(Member.class, 99L);

//            System.out.println("find member name is : " + findMember.getName());
//            System.out.println("find member id is   : " + findMember.getId());
//            System.out.println(" result is  :  " + (findMember1.getName() == findMember2.getName()));

//            Member memberA = new Member(101L, "A");
//            Member memberB = new Member(102L, "B");
//
//            // Not Yet Insert Db
//            em.persist(memberA);
//            em.persist(memberB);

            Member member = em.find(Member.class, 101L);
            member.setName("AAA");
            

            // DB INSERT
            tx.commit();
            System.out.println("=====Commit After=====");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
