package br.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Faz o controle de instâncias do EntityManagerFactory usando Singleton.
 * @author diego.vogel
 */
public class HibernateUtil {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static HibernateUtil instance = new HibernateUtil();

	private HibernateUtil() {

	}

	public static HibernateUtil getInstance() {
		return instance;
	}

	public static EntityManager create() {
		try {
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("Maven-EJB-JPA-JSF");
			}
			em = emf.createEntityManager();

		} catch (Exception e) {
			System.out.println("Não conseguiu acesar o Banco ");
		}
		return em;
	}
}