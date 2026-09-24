package be.abdullah;

import be.abdullah.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Employee emp = new Employee();
            emp.setName("Alice");
            emp.setAddress("Address");

            em.persist(emp);
            em.getTransaction().commit();
        }
    }
}
