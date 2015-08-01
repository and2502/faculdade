package br.com.reserva.aerea.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * The persistent class for the TRECHO database table.
 * 
 */
@Entity
@Table(name="TRECHO")
public class Trecho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TRECHO")
	private int idTrecho;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HORARIO_CHEGADA")
	private Calendar horarioChegada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HORARIO_PARTIDA")
	private Calendar horarioPartida;

	@Column(name="PRECO")
	private double preco;

	//bi-directional many-to-one association to Aeroporto
	@ManyToOne
	@JoinColumn(name="ID_AEROPORTO_ORIGEM")
	private Aeroporto aeroportoOrigem;

	//bi-directional many-to-one association to Aeroporto
	@ManyToOne
	@JoinColumn(name="ID_AEROPORTO_DESTINO")
	private Aeroporto aeroportoDestino;

	//bi-directional many-to-one association to Voo
	@ManyToOne
	@JoinColumn(name="ID_VOO")
	private Voo voo;

	public Trecho() {
	}

	public int getIdTrecho() {
		return this.idTrecho;
	}

	public void setIdTrecho(int idTrecho) {
		this.idTrecho = idTrecho;
	}

	public Calendar getHorarioChegada() {
		return this.horarioChegada;
	}

	public void setHorarioChegada(Calendar horarioChegada) {
		this.horarioChegada = horarioChegada;
	}

	public Calendar getHorarioPartida() {
		return this.horarioPartida;
	}

	public void setHorarioPartida(Calendar horarioPartida) {
		this.horarioPartida = horarioPartida;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Aeroporto getAeroportoOrigem() {
		return this.aeroportoOrigem;
	}

	public void setAeroportoOrigem(Aeroporto aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	public Aeroporto getAeroportoDestino() {
		return this.aeroportoDestino;
	}

	public void setAeroportoDestino(Aeroporto aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	public Voo getVoo() {
		return this.voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	public String getHorarioPartidaFormatado(){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(this.horarioPartida.getTime());
	}
	
	public String getHorarioChegadaFormatado(){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(this.horarioChegada.getTime());
	}

}