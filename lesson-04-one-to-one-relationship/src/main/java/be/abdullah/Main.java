package be.abdullah;

import be.abdullah.entities.Unidirectional.Profile;
import be.abdullah.entities.Unidirectional.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

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

}
