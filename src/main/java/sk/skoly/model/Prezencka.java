package sk.skoly.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Prezencka extends Entita {
	private Lekcia lekcia;
	private VyucovacieMiesto vyucovacieMiesto;
	private Lektor lektor;
	private String obsahVyuky;

	private BigDecimal cenaLektora;
	private Date zaciatok;
	private Date koniec;

	@ManyToOne()
	public Lekcia getLekcia() {
		return lekcia;
	}

	public void setLekcia(Lekcia lekcia) {
		this.lekcia = lekcia;
	}

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public VyucovacieMiesto getVyucovacieMiesto() {
		return vyucovacieMiesto;
	}

	public void setVyucovacieMiesto(VyucovacieMiesto vyucovacieMiesto) {
		this.vyucovacieMiesto = vyucovacieMiesto;
	}

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public Lektor getLektor() {
		return lektor;
	}

	public void setLektor(Lektor lektor) {
		this.lektor = lektor;
	}

	public String getObsahVyuky() {
		return obsahVyuky;
	}

	public void setObsahVyuky(String obsahVyuky) {
		this.obsahVyuky = obsahVyuky;
	}

	public BigDecimal getCenaLektora() {
		return cenaLektora;
	}

	public void setCenaLektora(BigDecimal cenaLektora) {
		this.cenaLektora = cenaLektora;
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
