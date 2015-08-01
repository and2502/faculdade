package br.com.reserva.aerea.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import br.com.reserva.aerea.entity.Assento;
import br.com.reserva.aerea.ws.ReservaWebService;
import br.com.reserva.aerea.ws.ReservaWebServiceProxy;

@ManagedBean(name = "confirmaReservaBean")
@ViewScoped
public class ConfirmaReservaBean extends AbstractBean implements Serializable {

	private Assento assento;
	
	public void selecionaAssento(Assento assento){
		if(assento.isDisponivel()){
			this.assento = assento;
		}else{
			addMessage("msgAlerta", "O Assento "+assento.getPosicao()+assento.getNrAssento()+" já está sendo utilizado");
		}
	}
	
	public String confirmaReserva(){
		try{
		HttpSession session = getHttpServletRequest().getSession(false);
		ReservaBean reservaBean = (session != null) ? (ReservaBean) session.getAttribute("reservaBean") : null;
		LoginBean loginBean = (session != null) ? (LoginBean) session.getAttribute("loginBean") : null;
		if(reservaBean.getTrecho() != null && loginBean.getUsuarioLogado() != null && assento != null){
			ReservaWebService reservaService = new ReservaWebServiceProxy();
			reservaService.efetuaReserva(loginBean.getUsuarioLogado().getCliente().getIdCliente(), assento.getIdAssento(), reservaBean.getTrecho().getIdTrecho());
		}
		}catch(Exception e){
			e.printStackTrace();
			return "/xhtml/private/confirmacaoReservaAerea.xhtml";
		}
		
		return "/xhtml/private/acompanheSuasReservas.xhtml?faces-redirect=true";
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}
