package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applicant")
public class Applicant {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String user;
	@Column(name = "password")
	private String password;
	
	public Applicant() {
	
	}

	public String getLogin() {
		return user;
	}

	public void setLogin(String login) {
		this.user = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", user=" + user + ", password=" + password + "]";
	}
	
	

}
