package org.proxima.spendtime.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the spendtime database table.
 * 
 */
@Entity
@Table(name="spendtime")
@NamedQuery(name="Spendtime.findAll", query="SELECT s FROM Spendtime s")
public class Spendtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sp")
	private int idSp;

	private String data;

	private int ora;

	private int tipoOre;

	private int userID;

	//bi-directional many-to-many association to Spendtimetip
	@ManyToMany
	@JoinTable(
		name="unionsp"
		, joinColumns={
			@JoinColumn(name="id_sp")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_spt")
			}
		)
	private List<Spendtimetip> spendtimetips;

	public Spendtime() {
	}

	public int getIdSp() {
		return this.idSp;
	}

	public void setIdSp(int idSp) {
		this.idSp = idSp;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getOra() {
		return this.ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public int getTipoOre() {
		return this.tipoOre;
	}

	public void setTipoOre(int tipoOre) {
		this.tipoOre = tipoOre;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<Spendtimetip> getSpendtimetips() {
		return this.spendtimetips;
	}

	public void setSpendtimetips(List<Spendtimetip> spendtimetips) {
		this.spendtimetips = spendtimetips;
	}

}