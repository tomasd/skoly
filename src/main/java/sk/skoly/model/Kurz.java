package sk.skoly.model;

import javax.persistence.Entity;

@Entity
public class Kurz extends Entita {
	private String kod;
	private Pouzivatel realizator;
	private Lektor lektor;
	private String nazov;
	private String poznamka;

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public Pouzivatel getRealizator() {
		return realizator;
	}

	public void setRealizator(Pouzivatel realizator) {
		this.realizator = realizator;
	}

	public Lektor getLektor() {
		return lektor;
	}

	public void setLektor(Lektor lektor) {
		this.lektor = lektor;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public String getPoznamka() {
		return poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

}
