package br.com.reserva.aerea.ws;

public class ReservaWebServiceProxy implements br.com.reserva.aerea.ws.ReservaWebService {
  private String _endpoint = null;
  private br.com.reserva.aerea.ws.ReservaWebService reservaWebService = null;
  
  public ReservaWebServiceProxy() {
    _initReservaWebServiceProxy();
  }
  
  public ReservaWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initReservaWebServiceProxy();
  }
  
  private void _initReservaWebServiceProxy() {
    try {
      reservaWebService = (new br.com.reserva.aerea.ws.ReservaWebServiceReservaEndpointLocator()).getReservaWebServiceImplPort();
      if (reservaWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reservaWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reservaWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reservaWebService != null)
      ((javax.xml.rpc.Stub)reservaWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.reserva.aerea.ws.ReservaWebService getReservaWebService() {
    if (reservaWebService == null)
      _initReservaWebServiceProxy();
    return reservaWebService;
  }
  
  public void efetuaReserva(java.lang.Integer idCliente, java.lang.Integer idAssento, java.lang.Integer idTrecho) throws java.rmi.RemoteException{
    if (reservaWebService == null)
      _initReservaWebServiceProxy();
    reservaWebService.efetuaReserva(idCliente, idAssento, idTrecho);
  }
  
  
}