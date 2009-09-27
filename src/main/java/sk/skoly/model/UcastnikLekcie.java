package sk.skoly.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class UcastnikLekcie extends Entita {
	private Prezencka prezencka;
	private UcastnikKurzu ucastnikKurzu;
	private boolean pritomny;
	private BigDecimal cena;

	@ManyToOne()
	public Prezencka getPrezencka() {
		return prezencka;
	}

	public void setPrezencka(Prezencka prezencka) {
		this.prezencka = prezencka;
	}

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public UcastnikKurzu getUcastnikKurzu() {
		return ucastnikKurzu;
	}

	public void setUcastnikKurzu(UcastnikKurzu ucastnikKurzu) {
		this.ucastnikKurzu = ucastnikKurzu;
	}

	public boolean isPritomny() {
		return pritomny;
	}

	public void setPritomny(boolean pritomny) {
		this.pritomny = pritomny;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

}
