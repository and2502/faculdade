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
	@OneToMany(mappedBy="voo")
	private List<CapacidadeVoo> capacidadeVoos;

	//bi-directional many-to-one association to Trecho
	@OneToMany(mappedBy="voo")
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

}