package br.com.reserva.aerea.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the VOO database table.
 * 
 */
@Entity
@Table(name="VOO")
public class Voo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VOO")
	private int idVoo;

	@Column(name="NR_VOO")
	private String nrVoo;

	//bi-directional many-to-one association to CapacidadeVoo
	@OneToMany(mappedBy="voo", cascade=CascadeType.ALL)
	private List<CapacidadeVoo> capacidadeVoos;

	//bi-directional many-to-one association to Trecho
	@OneToMany(mappedBy="voo", cascade=CascadeType.ALL )
	private List<Trecho> trechos;

	public Voo() {
	}

	public int getIdVoo() {
		return this.idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

	public String getNrVoo() {
		return this.nrVoo;
	}

	public void setNrVoo(String nrVoo) {
		this.nrVoo = nrVoo;
	}

	public List<CapacidadeVoo> getCapacidadeVoos() {
		return this.capacidadeVoos;
	}

	public void setCapacidadeVoos(List<CapacidadeVoo> capacidadeVoos) {
		this.capacidadeVoos = capacidadeVoos;
	}

	public CapacidadeVoo addCapacidadeVoo(CapacidadeVoo capacidadeVoo) {
		getCapacidadeVoos().add(capacidadeVoo);
		capacidadeVoo.setVoo(this);

		return capacidadeVoo;
	}

	public CapacidadeVoo removeCapacidadeVoo(CapacidadeVoo capacidadeVoo) {
		getCapacidadeVoos().remove(capacidadeVoo);
		capacidadeVoo.setVoo(null);

		return capacidadeVoo;
	}

	public List<Trecho> getTrechos() {
		return this.trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	public Trecho addTrecho(Trecho trecho) {
		getTrechos().add(trecho);
		trecho.setVoo(this);

		return trecho;
	}

	public Trecho removeTrecho(Trecho trecho) {
		getTrechos().remove(trecho);
		trecho.setVoo(null);

		return trecho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacidadeVoos == null) ? 0 : capacidadeVoos.hashCode());
		result = prime * result + idVoo;
		result = prime * result + ((nrVoo == null) ? 0 : nrVoo.hashCode());
		result = prime * result + ((trechos == null) ? 0 : trechos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		if (capacidadeVoos == null) {
			if (other.capacidadeVoos != null)
				return false;
		} else if (!capacidadeVoos.equals(other.capacidadeVoos))
			return false;
		if (idVoo != other.idVoo)
			return false;
		if (nrVoo == null) {
			if (other.nrVoo != null)
				return false;
		} else if (!nrVoo.equals(other.nrVoo))
			return false;
		if (trechos == null) {
			if (other.trechos != null)
				return false;
		} else if (!trechos.equals(other.trechos))
			return false;
		return true;
	}

}