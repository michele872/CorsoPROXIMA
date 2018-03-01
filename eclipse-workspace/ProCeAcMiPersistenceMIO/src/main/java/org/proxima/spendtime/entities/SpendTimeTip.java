package org.proxima.spendtime.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the spendtimetips database table.
 * 
 */
@Entity
@Table(name="spendtimetips")
@NamedQuery(name="Spendtimetip.findAll", query="SELECT s FROM Spendtimetip s")
public class Spendtimetip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_spt")
	private int idSpt;

	private String descrizione;

	private String label;

	//bi-directional many-to-many association to Spendtime
	@ManyToMany(mappedBy="spendtimetips")
	private List<Spendtime> spendtimes;

	public Spendtimetip() {
	}

	public int getIdSpt() {
		return this.idSpt;
	}

	public void setIdSpt(int idSpt) {
		this.idSpt = idSpt;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Spendtime> getSpendtimes() {
		return this.spendtimes;
	}

	public void setSpendtimes(List<Spendtime> spendtimes) {
		this.spendtimes = spendtimes;
	}

}