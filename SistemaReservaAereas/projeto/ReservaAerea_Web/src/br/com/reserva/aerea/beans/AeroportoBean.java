package br.com.reserva.aerea.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.reserva.aerea.dao.AeroportoDAO;
import br.com.reserva.aerea.entity.Aeroporto;

@ManagedBean(name = "aeroportoBean")
@RequestScoped
public class AeroportoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String jsonAeroportos;

	@EJB
	private AeroportoDAO aeroportoDAO;

	@PostConstruct
	public void inicializar() {
		List<Aeroporto> listaAeroportos = aeroportoDAO.findAll();
		if(listaAeroportos != null && !listaAeroportos.isEmpty()){
			StringBuilder json = new StringBuilder();
			json.append("[");
			for (Aeroporto a : listaAeroportos) {
				json.append(a.toString()).append(",");
			}
			json.append("]");
			this.jsonAeroportos = json.toString();
		}
		System.out.println(jsonAeroportos);
	}

	public String getJsonAeroportos() {
		return jsonAeroportos;
	}
	
	public void setJsonAeroportos(String jsonAeroportos) {
		this.jsonAeroportos = jsonAeroportos;
	}

}
