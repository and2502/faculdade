package br.com.reserva.aerea.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import br.com.reserva.aerea.entity.Assento;
import br.com.reserva.aerea.entity.Trecho;

@ManagedBean(name = "reservaBean")
@SessionScoped
public class ReservaBean extends AbstractBean implements Serializable {

	private Trecho trecho;
	private Assento assento;

	@PostConstruct
	private void init() {

	}

	public String addNoCarrino(Trecho trecho) {
		this.trecho = trecho;
		return "/xhtml/private/confirmacaoReservaAerea.xhtml?faces-redirect=true";
	}
	
	public void selecionaAssento(Assento assento){
		System.out.println(assento.getPosicao()+"-"+assento.getNrAssento());
		this.assento = assento;
	}

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}
