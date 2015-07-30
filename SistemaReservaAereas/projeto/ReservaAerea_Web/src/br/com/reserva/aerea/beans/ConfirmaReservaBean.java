package br.com.reserva.aerea.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.dao.ClienteDAO;
import br.com.reserva.aerea.dao.ReservaDAO;
import br.com.reserva.aerea.dao.TrechoDAO;
import br.com.reserva.aerea.entity.Assento;
import br.com.reserva.aerea.entity.Reserva;

@ManagedBean(name = "confirmaReservaBean")
@ViewScoped
public class ConfirmaReservaBean extends AbstractBean implements Serializable {

	private Assento assento;
	@EJB
	private AssentoDAO assentoDAO;
	@EJB
	private ReservaDAO reservaDAO;
	@EJB
	private ClienteDAO clienteDAO;
	@EJB
	private TrechoDAO trechoDAO;

	
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
			Reserva reserva = new Reserva();
			reserva.setAssento(assentoDAO.searchByID(assento.getIdAssento()));
			reserva.setCliente(clienteDAO.searchByID(loginBean.getUsuarioLogado().getCliente().getIdCliente()));
			reserva.setTrecho(trechoDAO.searchByID(reservaBean.getTrecho().getIdTrecho()));
			reservaDAO.insert(reserva);
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
