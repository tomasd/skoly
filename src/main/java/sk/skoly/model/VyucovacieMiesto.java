package sk.skoly.model;

public class VyucovacieMiesto extends Entita {
	private String nazov;
	private boolean obsaditelne;
	private SkupinaVyucovacichMiest skupinaVyucovacichMiest;
	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public boolean isObsaditelne() {
		return obsaditelne;
	}
	public void setObsaditelne(boolean obsaditelne) {
		this.obsaditelne = obsaditelne;
	}
	public SkupinaVyucovacichMiest getSkupinaVyucovacichMiest() {
		return skupinaVyucovacichMiest;
	}
	public void setSkupinaVyucovacichMiest(SkupinaVyucovacichMiest skupinaVyucovacichMiest) {
		this.skupinaVyucovacichMiest = skupinaVyucovacichMiest;
	}
	
	
}
