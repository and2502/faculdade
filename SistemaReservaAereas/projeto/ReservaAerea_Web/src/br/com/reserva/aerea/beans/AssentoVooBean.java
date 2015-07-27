package br.com.reserva.aerea.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.dao.CapacidadeVooDAO;
import br.com.reserva.aerea.entity.Assento;
import br.com.reserva.aerea.entity.CapacidadeVoo;

@ManagedBean(name = "assentoVooBean")
@RequestScoped
public class AssentoVooBean extends AbstractBean implements Serializable {

	private static final int MAX_ASSENTO_POR_CLASSE_EXECUTIVO = 5;
	private static final int MAX_ASSENTO_POR_CLASSE_ECONOMICA = 16;
	@EJB
	private CapacidadeVooDAO capacidadeVooDAO;
	@EJB
	private AssentoDAO assentoDAO;
	
	private List<Assento> listAssentosExecutivoA = new ArrayList<Assento>();
	private List<Assento> listAssentosExecutivoB = new ArrayList<Assento>();
	private List<Assento> listAssentosExecutivoC = new ArrayList<Assento>();
	private List<Assento> listAssentosExecutivoD = new ArrayList<Assento>();
	private List<Assento> listAssentosExecutivoF = new ArrayList<Assento>();
	private List<Assento> listAssentosExecutivoG = new ArrayList<Assento>();
	
	private List<Assento> listAssentosEconomicoA = new ArrayList<Assento>();
	private List<Assento> listAssentosEconomicoB = new ArrayList<Assento>();
	private List<Assento> listAssentosEconomicoC = new ArrayList<Assento>();
	private List<Assento> listAssentosEconomicoD = new ArrayList<Assento>();
	private List<Assento> listAssentosEconomicoF = new ArrayList<Assento>();
	private List<Assento> listAssentosEconomicoG = new ArrayList<Assento>();
	
	@PostConstruct
	private void init() {
		HttpSession session = getHttpServletRequest().getSession(false);
		ReservaBean reserva = (session != null) ? (ReservaBean) session.getAttribute("reservaBean") : null;
		if(reserva.getTrecho() != null){
			CapacidadeVoo capacidadeVooExecutiva = capacidadeVooDAO.findCapacidadeVooExecutivoByIdVoo(reserva.getTrecho().getVoo().getIdVoo());
			CapacidadeVoo capacidadeVooEconomica = capacidadeVooDAO.findCapacidadeVooEconomicoByIdVoo(reserva.getTrecho().getVoo().getIdVoo());
			populaAssentos(capacidadeVooExecutiva.getQtdeAssento(), "Executiva");
			populaAssentos(capacidadeVooEconomica.getQtdeAssento(), "Economica");
		}
	}

	private void populaAssentos(int qtdeAssento, String tipo) {
		int count = 0;
		String[] classes = new String[]{"A","B","C","D","F","G"};
		while (count < 6) {
			if("Executiva".equalsIgnoreCase(tipo)){
				qtdeAssento = buildAssentosExecutivoInVoo(qtdeAssento, classes[count]);
			}else if("Economica".equalsIgnoreCase(tipo)){
				qtdeAssento = buildAssentosEconomicaInVoo(qtdeAssento, classes[count]);
			}
			count++;
		}
		
	}

	private int buildAssentosEconomicaInVoo(int qtdeAssento, String classe) {
		for(int i = 6; qtdeAssento > 0; i++){
			getListAssentoVooByClasse(classe, "Economica").add(assentoDAO.findAssentoByNrAndClasse(i, classe));
			qtdeAssento = qtdeAssento - 1;
			if(i == MAX_ASSENTO_POR_CLASSE_ECONOMICA){break;}
		}
		return qtdeAssento;
	}

	private int buildAssentosExecutivoInVoo(int qtdeAssento, String classe) {
		for(int i = 1; qtdeAssento > 0; i++){
			getListAssentoVooByClasse(classe, "Executiva").add(assentoDAO.findAssentoByNrAndClasse(i, classe));
			qtdeAssento = qtdeAssento - 1;
			if(i == MAX_ASSENTO_POR_CLASSE_EXECUTIVO){break;}
		}
		return qtdeAssento;
	}
	
	private List<Assento> getListAssentoVooByClasse(String classe, String tipo){
		if("Executiva".equalsIgnoreCase(tipo)){
			if("A".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoA;
			if("B".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoB;
			if("C".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoC;
			if("D".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoD;
			if("F".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoF;
			if("G".equalsIgnoreCase(classe))
				return this.listAssentosExecutivoG;
		}else if("Economica".equalsIgnoreCase(tipo)){
			if("A".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoA;
			if("B".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoB;
			if("C".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoC;
			if("D".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoD;
			if("F".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoF;
			if("G".equalsIgnoreCase(classe))
				return this.listAssentosEconomicoG;
		}
		return null;
	}

	public List<Assento> getListAssentosExecutivoA() {
		return listAssentosExecutivoA;
	}

	public List<Assento> getListAssentosExecutivoB() {
		return listAssentosExecutivoB;
	}

	public List<Assento> getListAssentosExecutivoC() {
		return listAssentosExecutivoC;
	}

	public List<Assento> getListAssentosExecutivoD() {
		return listAssentosExecutivoD;
	}

	public List<Assento> getListAssentosExecutivoF() {
		return listAssentosExecutivoF;
	}

	public List<Assento> getListAssentosExecutivoG() {
		return listAssentosExecutivoG;
	}

	public List<Assento> getListAssentosEconomicoA() {
		return listAssentosEconomicoA;
	}

	public List<Assento> getListAssentosEconomicoB() {
		return listAssentosEconomicoB;
	}

	public List<Assento> getListAssentosEconomicoC() {
		return listAssentosEconomicoC;
	}

	public List<Assento> getListAssentosEconomicoD() {
		return listAssentosEconomicoD;
	}

	public List<Assento> getListAssentosEconomicoF() {
		return listAssentosEconomicoF;
	}

	public List<Assento> getListAssentosEconomicoG() {
		return listAssentosEconomicoG;
	}

	public void setListAssentosExecutivoA(List<Assento> listAssentosExecutivoA) {
		this.listAssentosExecutivoA = listAssentosExecutivoA;
	}

	public void setListAssentosExecutivoB(List<Assento> listAssentosExecutivoB) {
		this.listAssentosExecutivoB = listAssentosExecutivoB;
	}

	public void setListAssentosExecutivoC(List<Assento> listAssentosExecutivoC) {
		this.listAssentosExecutivoC = listAssentosExecutivoC;
	}

	public void setListAssentosExecutivoD(List<Assento> listAssentosExecutivoD) {
		this.listAssentosExecutivoD = listAssentosExecutivoD;
	}

	public void setListAssentosExecutivoF(List<Assento> listAssentosExecutivoF) {
		this.listAssentosExecutivoF = listAssentosExecutivoF;
	}

	public void setListAssentosExecutivoG(List<Assento> listAssentosExecutivoG) {
		this.listAssentosExecutivoG = listAssentosExecutivoG;
	}

	public void setListAssentosEconomicoA(List<Assento> listAssentosEconomicoA) {
		this.listAssentosEconomicoA = listAssentosEconomicoA;
	}

	public void setListAssentosEconomicoB(List<Assento> listAssentosEconomicoB) {
		this.listAssentosEconomicoB = listAssentosEconomicoB;
	}

	public void setListAssentosEconomicoC(List<Assento> listAssentosEconomicoC) {
		this.listAssentosEconomicoC = listAssentosEconomicoC;
	}

	public void setListAssentosEconomicoD(List<Assento> listAssentosEconomicoD) {
		this.listAssentosEconomicoD = listAssentosEconomicoD;
	}

	public void setListAssentosEconomicoF(List<Assento> listAssentosEconomicoF) {
		this.listAssentosEconomicoF = listAssentosEconomicoF;
	}

	public void setListAssentosEconomicoG(List<Assento> listAssentosEconomicoG) {
		this.listAssentosEconomicoG = listAssentosEconomicoG;
	}

}
