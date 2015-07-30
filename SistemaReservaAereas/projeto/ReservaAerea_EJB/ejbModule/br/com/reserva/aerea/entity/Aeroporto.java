package br.com.reserva.aerea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The persistent class for the AEROPORTO database table.
 * 
 */
@Entity
@Table(name="AEROPORTO")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="aeroporto")
public class Aeroporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AEROPORTO")
	private int idAeroporto;

	@Column(name="LATITUDE")
	private String latitude;

	@Column(name="LOCALIZACAO")
	private String localizacao;

	@Column(name="LONGITUDE")
	private String longitude;

	@Column(name="NOME")
	private String nome;

	public Aeroporto() {
	}

	public int getIdAeroporto() {
		return this.idAeroporto;
	}

	public void setIdAeroporto(int idAeroporto) {
		this.idAeroporto = idAeroporto;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
	   return "{latLng: [" + this.latitude+", "+this.longitude + "], name:'" +nome+ "'}";
	}
}