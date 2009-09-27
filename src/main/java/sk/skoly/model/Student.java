package sk.skoly.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Student extends Entita {
	private String priezvisko;
	private String meno;
	private String titul;
	private Platca platca;

	private String ulica;
	private String psc;
	private String mesto;

	private String telefon;
	private String mobil;
	private String fax;
	private String www;
	private String email;

	public String getPriezvisko() {
		return priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getTitul() {
		return titul;
	}

	public void setTitul(String titul) {
		this.titul = titul;
	}

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ListDisplayed
	public Platca getPlatca() {
		return platca;
	}

	public void setPlatca(Platca platca) {
		this.platca = platca;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getPsc() {
		return psc;
	}

	public void setPsc(String psc) {
		this.psc = psc;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	@ListDisplayed
	public String getFormatedName() {
		return String.format("%s, %s", priezvisko, meno);
	}
	
	@Override
	public String toString() {
		return getFormatedName();
	}
}
