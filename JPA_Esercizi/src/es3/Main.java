package es3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence-unit3");
		EntityManager em = emFactory.createEntityManager();
		em.close();
		emFactory.close();
	}

}
