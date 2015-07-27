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


/**
 * The persistent class for the RESERVA database table.
 * 
 */
@Entity
@Table(name="RESERVA")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESERVA")
	private int idReserva;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Assento
	@ManyToOne
	@JoinColumn(name="ID_ASSENTO")
	private Assento assento;

	//bi-directional many-to-one association to Voo
	@ManyToOne
	@JoinColumn(name="ID_TRECHO")
	private Trecho trecho;

	public Reserva() {
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	
}