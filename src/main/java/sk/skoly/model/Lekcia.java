package sk.skoly.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Lekcia extends Entita {
	private Kurz kurz;
	private VyucovacieMiesto vyucovacieMiesto;
	private Date zaciatok;
	private Date koniec;

	public Kurz getKurz() {
		return kurz;
	}

	public void setKurz(Kurz kurz) {
		this.kurz = kurz;
	}

	public VyucovacieMiesto getVyucovacieMiesto() {
		return vyucovacieMiesto;
	}

	public void setVyucovacieMiesto(VyucovacieMiesto vyucovacieMiesto) {
		this.vyucovacieMiesto = vyucovacieMiesto;
	}

	public Date getZaciatok() {
		return zaciatok;
	}

	public void setZaciatok(Date zaciatok) {
		this.zaciatok = zaciatok;
	}

	public Date getKoniec() {
		return koniec;
	}

	public void setKoniec(Date koniec) {
		this.koniec = koniec;
	}

}
