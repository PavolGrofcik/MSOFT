package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Inicializ�cia Hibernate JPA
 * @author grofc
 *
 */


public class HibernateUtil {
	
	private static SessionFactory factory;
	
	//Na��tanie cfg s�boru na init
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
