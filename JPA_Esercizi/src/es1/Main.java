package es1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit2");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}

}
