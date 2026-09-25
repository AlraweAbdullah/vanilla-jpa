package be.abdullah;

import be.abdullah.entities.bidirectional.Employee;
import be.abdullah.entities.bidirectional.Office;
import be.abdullah.entities.unidirectional.Profile;
import be.abdullah.entities.unidirectional.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //unidirectional relationship
        //unidirectional();
        //bidirectional relationship
        bidirectional();
    }

    private static void unidirectional() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Profile profile = new Profile();
            profile.setUserName("AliceInWonderLand");
            User  user = new User();
            user.setName("Alice");
            user.setProfile(profile);

            em.persist(profile);
            em.persist(user);

            em.getTransaction().commit();
        }
    }

    private static void bidirectional() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Office office = new Office();
            office.setName("B2");

            Employee  employee = new Employee();
            employee.setName("Alice");
            employee.setOffice(office);

            office.setEmployee(employee);


            em.persist(office);
            em.persist(employee);

            em.getTransaction().commit();
        }
    }

}
