package singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.Main;
import model.Applicant;
import model.Application;
import model.Grant;

/**
 * Singleton Controller na riadenie business logiky aplik�cie
 * Pr�ca s DB pomocou Hibernate JPA
 * Zakomentovan� riadky vy�aduj� nastaven� lok�lnu DB
 * @author grofc
 *
 */


public class BusinessLogicController {
	
	//private SessionFactory factory;
	private static BusinessLogicController controller;

	private static Grant grant;
	private static Applicant user;
	
	
	/*Kon�truktor*/
	private BusinessLogicController() {
		//this.factory = HibernateUtil.getSessionFactory();
	}
	
	
	/*Met�da vr�ti single in�tanciu Controller-a*/
	public static BusinessLogicController getInstance() {
		if(controller == null) {
			controller = new BusinessLogicController();
		}
		
		return controller;
	}
	
	
	/*Met�da ukon�� session s DB*/
	public void shutDown() {
		//this.factory.close();
	}
	
	
	/*Met�da na overenie zadan�ch prihlasovac�ch �dajov */
	public boolean login(String username, String password) {
		
		/*Session session = factory.openSession();
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
		}*/
		
		return true;
	}
	
	/*Met�da vytvor� nov� �iados� */
	public static void createApplication(String name, String surname, String company,
			String description) {
		if(grant == null) {
			System.out.println("Grant not selected!");
		}else {
			
			new Application(name,surname,company,description,grant.getId());
			
			//Zaevidovanie novej �iadosti
		/*	Application application = new Application(name, surname, company, description, grant.getId());
			application.setId(2);
			application.setCharged(false);
			application.setPaid(false);
			
			Session session = Main.controller.factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(application);
			
			tx.commit();
			session.close();
			*/
		}
	}
	
	/*Met�da prida zvolen� Grant na vytvorenie �iadosti*/
	public static void setSelectedGrant(Grant grant) {
		BusinessLogicController.grant = grant;
	}
	
}
