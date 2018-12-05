package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Inicializácia Hibernate JPA
 * @author grofc
 *
 */


public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static void closeSessionFactory() {
		factory.close();
	}
	
	
}
