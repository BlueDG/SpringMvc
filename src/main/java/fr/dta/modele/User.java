package fr.dta.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.dta.persistence.IoEntity;
import fr.dta.validation.Password;

@Entity
@Table(name = "user_")
public class User implements IoEntity {


	private static final long serialVersionUID = 5571896754546918157L;
	@Id @GeneratedValue long id;
	@Column String login;
	@Column @Password String password;
	@Column String name;
	
	public User(String login) {
		this.login = login;
	}
	
	public User() {
		super();
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getId() {
		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	
	
}


