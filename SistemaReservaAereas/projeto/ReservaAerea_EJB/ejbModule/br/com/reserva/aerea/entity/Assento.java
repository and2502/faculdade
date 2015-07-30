package br.com.reserva.aerea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The persistent class for the ASSENTO database table.
 * 
 */
@Entity
@Table(name="ASSENTO")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="assento")
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
	
	private transient boolean isDisponivel;

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

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

}