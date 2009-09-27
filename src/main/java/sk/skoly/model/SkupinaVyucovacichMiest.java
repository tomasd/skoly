package sk.skoly.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class SkupinaVyucovacichMiest extends Entita {
	private String nazov;
	private String ulica;
	private String psc;
	private String mesto;

	@ListDisplayed(order=1)
	public String getNazov() {
		return nazov;
	}

	@Transient
	@ListDisplayed
	public String getAdresa() {
		return String.format("%s, %s %s", ulica, psc, mesto);
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
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

	@Override
	public String toString() {
		return nazov;
	}
}
