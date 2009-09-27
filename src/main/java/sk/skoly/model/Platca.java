package sk.skoly.model;

import javax.persistence.Entity;

@Entity
public class Platca extends Entita {
	private String nazov;

	private String ico;
	private String dic;
	private String icDph;

	private String ulica;
	private String psc;
	private String mesto;

	private String telefon;
	private String mobil;
	private String fax;
	private String www;
	private String email;

	@ListDisplayed
	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getDic() {
		return dic;
	}

	public void setDic(String dic) {
		this.dic = dic;
	}

	public String getIcDph() {
		return icDph;
	}

	public void setIcDph(String icDph) {
		this.icDph = icDph;
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

	@Override
	public String toString() {
		return nazov;
	}
}
