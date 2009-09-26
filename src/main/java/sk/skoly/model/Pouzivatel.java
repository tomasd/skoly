package sk.skoly.model;

import javax.persistence.Entity;

@Entity
public class Pouzivatel extends Entita {
	private String login;
	private String heslo;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHeslo() {
		return heslo;
	}

	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}

}
