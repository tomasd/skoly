package sk.skoly.model;

public class NakladovaSkupina extends Entita {
	private String nazov;
	private Kurz kurz;
	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public Kurz getKurz() {
		return kurz;
	}
	public void setKurz(Kurz kurz) {
		this.kurz = kurz;
	}
	
	
}
