package br.com.reserva.aerea.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAPACIDADE_VOO database table.
 * 
 */
@Entity
@Table(name="CAPACIDADE_VOO")
public class CapacidadeVoo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CAPACIDADE_VOO")
	private int idCapacidadeVoo;

	@Column(name="QTDE_ASSENTO")
	private int qtdeAssento;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="ID_CLASSE")
	private Classe classe;

	//bi-directional many-to-one association to Voo
	@ManyToOne
	@JoinColumn(name="ID_VOO")
	private Voo voo;
	

	public CapacidadeVoo() {
	}
	
	public CapacidadeVoo(int qtdeAssentos, Classe classe) {
		this.qtdeAssento = qtdeAssentos;
		this.classe = classe;
	}

	public int getIdCapacidadeVoo() {
		return this.idCapacidadeVoo;
	}

	public void setIdCapacidadeVoo(int idCapacidadeVoo) {
		this.idCapacidadeVoo = idCapacidadeVoo;
	}

	public int getQtdeAssento() {
		return this.qtdeAssento;
	}

	public void setQtdeAssento(int qtdeAssento) {
		this.qtdeAssento = qtdeAssento;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Voo getVoo() {
		return this.voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

}