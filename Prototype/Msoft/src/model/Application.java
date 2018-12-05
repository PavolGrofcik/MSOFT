package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {

	@Id
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="company")
	private String companyName;
	@Column(name="description")
	private String description;
	private Date date;
	@Column(name="grant_id")
	private int grantId;
	@Column(name="charged")
	private boolean charged;
	@Column(name="paid")
	private boolean paid;
	
	
	public Application(int id, String name, String surname, String companyName, String description, Date date,
			int grantId, boolean charged, boolean paid) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.companyName = companyName;
		this.description = description;
		this.date = date;
		this.grantId = grantId;
		this.charged = charged;
		this.paid = paid;
	}


	public Application(int id, String name, String surname, String companyName, String description, int grantId) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.companyName = companyName;
		this.description = description;
		this.grantId = grantId;
		
		
	}
	
	
	
	public Application(String name, String surname, String companyName, String description, int grantId) {
		super();
		this.name = name;
		this.surname = surname;
		this.companyName = companyName;
		this.description = description;
		this.grantId = grantId;
	}


	public Application() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getGrantId() {
		return grantId;
	}


	public void setGrantId(int grantId) {
		this.grantId = grantId;
	}


	public boolean isCharged() {
		return charged;
	}


	public void setCharged(boolean charged) {
		this.charged = charged;
	}


	public boolean isPaid() {
		return paid;
	}


	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
}
