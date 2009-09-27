package sk.skoly.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class NakladovaSkupina extends Entita {
	private String nazov;
	private Kurz kurz;

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	@ManyToOne()
	public Kurz getKurz() {
		return kurz;
	}

	public void setKurz(Kurz kurz) {
		this.kurz = kurz;
	}

}
