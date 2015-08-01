package br.com.reserva.aerea.ws;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.dao.ClienteDAO;
import br.com.reserva.aerea.dao.ReservaDAO;
import br.com.reserva.aerea.dao.TrechoDAO;
import br.com.reserva.aerea.entity.Reserva;

@WebService(serviceName="ReservaWebService/reservaEndpoint")
public class ReservaWebServiceImpl implements ReservaWebService{

	@EJB
	private AssentoDAO assentoDAO;
	@EJB
	private ReservaDAO reservaDAO;
	@EJB
	private ClienteDAO clienteDAO;
	@EJB
	private TrechoDAO trechoDAO;
	
	@Override
	public void efetuaReserva(@WebParam(name="idCliente") Integer idCliente, 
			   @WebParam(name="idAssento") Integer idAssento,
			   @WebParam(name="idTrecho") Integer idTrecho) {
		Reserva reserva = new Reserva();
		reserva.setAssento(assentoDAO.searchByID(idAssento));
		reserva.setCliente(clienteDAO.searchByID(idCliente));
		reserva.setTrecho(trechoDAO.searchByID(idTrecho));
		reservaDAO.insert(reserva);
		
	}

}
