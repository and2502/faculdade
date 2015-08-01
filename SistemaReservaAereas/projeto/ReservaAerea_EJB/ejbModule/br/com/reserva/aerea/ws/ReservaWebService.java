package br.com.reserva.aerea.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ReservaWebService {

	@WebMethod
	void efetuaReserva(@WebParam(name="idCliente") Integer idCliente, 
					   @WebParam(name="idAssento") Integer idAssento,
					   @WebParam(name="idTrecho") Integer idTrecho);
}
