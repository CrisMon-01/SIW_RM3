package es4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit4");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Versione v = new Versione();
//		Versione v1 = new Versione();
//		Versione v2 = new Versione();
//		v1.setId((long) 1);
//		v2.setId((long) 1);
		Auto a = new Auto();
//		Modello m = new Modello();
//		v.setModello(m);
		tx.begin();
//		em.persist(m);
		em.persist(v);
//		em.persist(v1);
//		em.persist(v2);
		tx.commit();
		em.close();
		emf.close();
	}

}
