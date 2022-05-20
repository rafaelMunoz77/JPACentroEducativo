package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Curso;
import modelo.Entidad;

public class CursoControlador extends SuperControlador {
	
	public static Curso obtenerPrimero () {
		return obtencionDesdeSQL("SELECT * FROM curso order by id limit 1");
	}	
	
	public static Curso obtenerUltimo () {
		return obtencionDesdeSQL("SELECT * FROM curso order by id desc limit 1");
	}	
	
	public static Curso obtenerSiguiente (int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id > " + idActual + " order by id limit 1");
	}	
	
	public static Curso obtenerAnterior (int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id < " + idActual + " order by id desc limit 1");
	}	
	
	/**
	 * 
	 */
	private static Curso obtencionDesdeSQL (String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, Curso.class);
		Curso c = (Curso) q.getSingleResult();
		
		em.close();
		
		return c;
	}

	
	
}
