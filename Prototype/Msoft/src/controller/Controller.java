package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.Main;
import model.Applicant;
import model.Application;
import model.Grant;

/**
 * Singleton Controller na riadenie business logiky aplik·cie
 * Pr·ca s DB pomocou Hibernate JPA
 * @author grofc
 *
 */


public class Controller {
	
	private SessionFactory factory;
	private static Controller controller;

	private static Grant grant;
	private static Applicant user;
	
	
	/*Konötruktor*/
	private Controller() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	
	/*MetÛda vr·ti single inötanciu Controller-a*/
	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		
		return controller;
	}
	
	
	/*MetÛda ukonËÌ session s DB*/
	public void shutDown() {
		this.factory.close();
	}
	
	
	/*MetÛda na overenie zadan˝ch prihlasovacÌch ˙dajov */
	public boolean login(String username, String password) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Applicant applicant = null;
		
		try {
			applicant = session.get(Applicant.class, 1);	
			user = applicant;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(applicant.equals(null)) {
			tx.commit();
			session.close();
			return false;
		}
		
		if (applicant.getLogin().equals(username)
				&& applicant.getPassword().equals(password)) {
			tx.commit();
			session.close();
			return true;
		}else {
			tx.commit();
			session.close();
			return false;
		}
	}
	
	/*MetÛda vytvorÌ nov˙ ûiadosù */
	public static void createApplication(String name, String surname, String company,
			String description) {
		if(grant == null) {
			System.out.println("Grant not selected!");
		}else {
			//Zaevidovanie novej ûiadosti
			Application application = new Application(name, surname, company, description, grant.getId());
			application.setId(2);
			application.setCharged(false);
			application.setPaid(false);
			
			Session session = Main.controller.factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(application);
			
			tx.commit();
			session.close();
			
		}
	}
	
	/*MetÛda prida zvolen˝ Grant na vytvorenie ûiadosti*/
	public static void setSelectedGrant(Grant grant) {
		Controller.grant = grant;
	}
	
}
