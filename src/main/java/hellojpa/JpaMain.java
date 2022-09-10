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

//            Member member = em.find(Member.class, 101L);
//            member.setName("AAA");

//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("==================================");
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("==================================");
//

            // one-way association
            // Save
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            // SEARCH
            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("find Team is : " + findTeam.getName());

            // Team Changed
//            Team newTeam = em.find(Team.class, 100L); // Need 100L Team
//            findMember.setTeam(newTeam);

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
