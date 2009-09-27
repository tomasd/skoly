package sk.skoly.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class MesacnyNakladVyucovacichMiest extends Entita {
	private SkupinaVyucovacichMiest skupinaVyucovacichMiest;
	private Date zaciatok;
	private Date koniec;
	private BigDecimal cena;

	@ManyToOne()
	public SkupinaVyucovacichMiest getSkupinaVyucovacichMiest() {
		return skupinaVyucovacichMiest;
	}

	public void setSkupinaVyucovacichMiest(SkupinaVyucovacichMiest skupinaVyucovacichMiest) {
		this.skupinaVyucovacichMiest = skupinaVyucovacichMiest;
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

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

}
