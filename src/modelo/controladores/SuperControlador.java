package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Entidad;

public class SuperControlador {

	protected static EntityManager createEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");
		return entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 * 
	 */
	private static void creacion (Entidad c) {
		EntityManager em = createEntityManager();

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		em.close();
	}
	
	
	
	/**
	 * 
	 */
	private static void modificacionEntidad (Entidad c) {
		EntityManager em = createEntityManager();

		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		
		em.close();
	}

	/**
	 * 
	 */
	public void remove(Entidad c) {
		EntityManager em = createEntityManager();

		em.getTransaction().begin();
		if (!em.contains(c)) {
			c = em.merge(c);
		}
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
