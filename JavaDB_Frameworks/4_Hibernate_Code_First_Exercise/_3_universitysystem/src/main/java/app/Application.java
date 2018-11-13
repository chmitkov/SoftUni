package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("university");

        EntityManager entityManager = factory.createEntityManager();

    }
}
