package br.com.reserva.aerea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLASSE database table.
 * 
 */
@Entity
@Table(name="CLASSE")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLASSE")
	private int idClasse;

	@Column(name="DESCRICAO")
	private String descricao;

	//bi-directional many-to-one association to Assento
	@OneToMany(mappedBy="classe")
	private List<Assento> assentos;

	//bi-directional many-to-one association to CapacidadeVoo
	@OneToMany(mappedBy="classe")
	private List<CapacidadeVoo> capacidadeVoos;

	public Classe() {
	}

	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Assento> getAssentos() {
		return this.assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public Assento addAssento(Assento assento) {
		getAssentos().add(assento);
		assento.setClasse(this);

		return assento;
	}

	public Assento removeAssento(Assento assento) {
		getAssentos().remove(assento);
		assento.setClasse(null);

		return assento;
	}

	public List<CapacidadeVoo> getCapacidadeVoos() {
		return this.capacidadeVoos;
	}

	public void setCapacidadeVoos(List<CapacidadeVoo> capacidadeVoos) {
		this.capacidadeVoos = capacidadeVoos;
	}

	public CapacidadeVoo addCapacidadeVoo(CapacidadeVoo capacidadeVoo) {
		getCapacidadeVoos().add(capacidadeVoo);
		capacidadeVoo.setClasse(this);

		return capacidadeVoo;
	}

	public CapacidadeVoo removeCapacidadeVoo(CapacidadeVoo capacidadeVoo) {
		getCapacidadeVoos().remove(capacidadeVoo);
		capacidadeVoo.setClasse(null);

		return capacidadeVoo;
	}

}