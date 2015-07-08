package br.com.reserva.aerea.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ASSENTO database table.
 * 
 */
@Entity
@Table(name="ASSENTO")
public class Assento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ASSENTO")
	private int idAssento;

	@Column(name="NR_ASSENTO")
	private String nrAssento;

	@Column(name="POSICAO")
	private String posicao;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="ID_CLASSE")
	private Classe classe;

	public Assento() {
	}

	public int getIdAssento() {
		return this.idAssento;
	}

	public void setIdAssento(int idAssento) {
		this.idAssento = idAssento;
	}

	public String getNrAssento() {
		return this.nrAssento;
	}

	public void setNrAssento(String nrAssento) {
		this.nrAssento = nrAssento;
	}

	public String getPosicao() {
		return this.posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}