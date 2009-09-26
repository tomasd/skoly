package sk.skoly.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class HodinovaSadzbaLektora extends Entita {
	private ZmluvaLektora zmluvaLektora;
	private Kurz kurz;
	private BigDecimal sadzba;

	private Date zaciatok;
	private Date koniec;

	public ZmluvaLektora getZmluvaLektora() {
		return zmluvaLektora;
	}

	public void setZmluvaLektora(ZmluvaLektora zmluvaLektora) {
		this.zmluvaLektora = zmluvaLektora;
	}

	public Kurz getKurz() {
		return kurz;
	}

	public void setKurz(Kurz kurz) {
		this.kurz = kurz;
	}

	public BigDecimal getSadzba() {
		return sadzba;
	}

	public void setSadzba(BigDecimal sadzba) {
		this.sadzba = sadzba;
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
