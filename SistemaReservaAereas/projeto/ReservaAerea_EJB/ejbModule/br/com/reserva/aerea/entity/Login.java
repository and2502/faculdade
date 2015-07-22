package br.com.reserva.aerea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
@Table(name="LOGIN")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LOGIN")
	private int idLogin;

	@Column(name="SENHA")
	private String senha;

	@Column(name="USUARIO")
	private String usuario;

	@OneToOne(mappedBy="login")
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@Column(name="ADMIN")
	private char admin;

	public Login() {
	}

	public int getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public char getAdmin() {
		return admin;
	}

	public void setAdmin(char admin) {
		this.admin = admin;
	}

}