package sk.skoly.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class UcastnikKurzu extends Entita {
	private Kurz kurz;
	private Student student;

	private Date zaciatok;
	private Date koniec;

	private NakladovaSkupina nakladovaSkupina;

	@ManyToOne()
	public Kurz getKurz() {
		return kurz;
	}

	public void setKurz(Kurz kurz) {
		this.kurz = kurz;
	}

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public NakladovaSkupina getNakladovaSkupina() {
		return nakladovaSkupina;
	}

	public void setNakladovaSkupina(NakladovaSkupina nakladovaSkupina) {
		this.nakladovaSkupina = nakladovaSkupina;
	}

}
