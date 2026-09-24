package be.abdullah;

import be.abdullah.entities.EmbeddedId.Account;
import be.abdullah.entities.EmbeddedId.AccountId;
import be.abdullah.entities.IdClass.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // @IdClass
        addProduct();

        // @EmbeddedId
        addAccount();

    }

    // @IdClass
    private static void addProduct() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Product product = new Product();
            product.setCode("123");
            product.setColor("Green");
            em.persist(product);

            em.getTransaction().commit();
        }
    }

    // @EmbeddedId
    private static void addAccount() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();

            AccountId accountId = new AccountId(123,"saving");

            Account account = new Account();
            account.setAccountId(accountId);

            em.persist(account);

            em.getTransaction().commit();
        }
    }
}
