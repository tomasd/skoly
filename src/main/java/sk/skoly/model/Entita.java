package sk.skoly.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Entita implements Serializable {
	private Integer id;
	private Date created;
	private Date updated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Entita) {
			Entita entita = (Entita) obj;
			return new EqualsBuilder().append(id, entita.getId()).append(getClass(), entita.getClass()).isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}
	
}
