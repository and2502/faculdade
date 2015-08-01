package br.com.reserva.aerea.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import br.com.reserva.aerea.dao.ReservaDAO;
import br.com.reserva.aerea.entity.Reserva;

@ManagedBean(name="acompanhamentoReservaBean")
public class AcompanhamentoReservaBean extends AbstractBean implements Serializable {


	private List<Reserva> listaReservas;
	
	@EJB
	private ReservaDAO reservaDAO;

	
	public List<Reserva> getAllReservas(){
		HttpSession session = getHttpServletRequest().getSession(false);
		LoginBean loginBean = (session != null) ? (LoginBean) session.getAttribute("loginBean") : null;
		if(loginBean.getUsuarioLogado() != null && (listaReservas == null || listaReservas.isEmpty())){
			Integer idCliente = loginBean.getUsuarioLogado().getCliente().getIdCliente();
			listaReservas = reservaDAO.findAllReservationByUserLogged(idCliente);
		}
		return this.listaReservas;
	}
}
