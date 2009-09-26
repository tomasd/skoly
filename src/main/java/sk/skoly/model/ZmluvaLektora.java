package sk.skoly.model;

import javax.persistence.Entity;

@Entity
public class ZmluvaLektora extends Entita {
	private String cisloZmluvy;
	private String lektor;
	private String standardnaHodinovaSadzba;
	private String zaciatok;
	private String koniec;

	public String getCisloZmluvy() {
		return cisloZmluvy;
	}

	public void setCisloZmluvy(String cisloZmluvy) {
		this.cisloZmluvy = cisloZmluvy;
	}

	public String getLektor() {
		return lektor;
	}

	public void setLektor(String lektor) {
		this.lektor = lektor;
	}

	public String getStandardnaHodinovaSadzba() {
		return standardnaHodinovaSadzba;
	}

	public void setStandardnaHodinovaSadzba(String standardnaHodinovaSadzba) {
		this.standardnaHodinovaSadzba = standardnaHodinovaSadzba;
	}

	public String getZaciatok() {
		return zaciatok;
	}

	public void setZaciatok(String zaciatok) {
		this.zaciatok = zaciatok;
	}

	public String getKoniec() {
		return koniec;
	}

	public void setKoniec(String koniec) {
		this.koniec = koniec;
	}

}
