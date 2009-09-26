package sk.skoly.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class UcastnikLekcie extends Entita {
	private Prezencka prezencka;
	private UcastnikKurzu ucastnikKurzu;
	private boolean pritomny;
	private BigDecimal cena;

	public Prezencka getPrezencka() {
		return prezencka;
	}

	public void setPrezencka(Prezencka prezencka) {
		this.prezencka = prezencka;
	}

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
