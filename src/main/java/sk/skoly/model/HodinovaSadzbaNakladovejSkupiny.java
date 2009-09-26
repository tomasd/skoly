package sk.skoly.model;

import java.math.BigDecimal;
import java.util.Date;

public class HodinovaSadzbaNakladovejSkupiny extends Entita {
	private NakladovaSkupina nakladovaSkupina;
	private Date zaciatok;
	private Date koniec;
	private BigDecimal sadzba;
	public NakladovaSkupina getNakladovaSkupina() {
		return nakladovaSkupina;
	}
	public void setNakladovaSkupina(NakladovaSkupina nakladovaSkupina) {
		this.nakladovaSkupina = nakladovaSkupina;
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
	public BigDecimal getSadzba() {
		return sadzba;
	}
	public void setSadzba(BigDecimal sadzba) {
		this.sadzba = sadzba;
	}
	
	
}