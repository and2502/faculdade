package br.com.reserva.aerea.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import br.com.reserva.aerea.dao.AeroportoDAO;
import br.com.reserva.aerea.dao.ClasseDAO;
import br.com.reserva.aerea.dao.TrechoDAO;
import br.com.reserva.aerea.dao.VooDAO;
import br.com.reserva.aerea.entity.CapacidadeVoo;
import br.com.reserva.aerea.entity.Classe;
import br.com.reserva.aerea.entity.Trecho;
import br.com.reserva.aerea.entity.Voo;
import br.com.reserva.aerea.util.CalendarUtil;

@ManagedBean(name="trechoVooBean")
public class TrechoVooBean extends AbstractBean implements Serializable {

	private static final int CHEGADA = 1;
	private static final int PARTIDA = 0;
	private static final long serialVersionUID = 1L;
	private static final Integer CLASSE_ECONOMICA = 1;
	private static final Integer CLASSE_EXECUTIVA = 2;
	private Integer qtdeTrechos;
	private Integer qtdeAssentosEconomico;
	private Integer qtdeAssentosExecutivo;
	private Voo voo;
	private List<Trecho> listaTrechos;
	
	@EJB
	private TrechoDAO trechoDAO;
	@EJB
	private ClasseDAO classeDAO;
	@EJB
	private AeroportoDAO aeroportoDAO;
	@EJB
	private VooDAO vooDAO;

	@PostConstruct
	public void inicializar() {
		voo = new Voo();
		voo.setTrechos(new ArrayList<Trecho>());
		voo.setCapacidadeVoos(new ArrayList<CapacidadeVoo>());
		this.voo.setNrVoo("A"+genereteNumeroAleatorio());
	}
	
	private int genereteNumeroAleatorio() {
		Random rn = new Random();
		int next = rn.nextInt(99999 - 1 + 1) + 4;
        return next;
	}

	public String registrarVoo(){
		String url = null;
		try{
			populaTrechos();
			populaCapacidades();
			vooDAO.insert(this.voo);
			url = "/xhtml/public/listaTreechoVoo.xhtml?faces-redirect=true";
			this.voo = new Voo();
		}catch(Exception e){
			addMessage("msg", "Problemas ao incluir os trechos do Voo!");
			e.printStackTrace();
		}
		return url;
	}
	
	private void populaTrechos() {
		Trecho trecho = null;
		HttpServletRequest req = getHttpServletRequest();
		String[] selAeroportoOrigem = req.getParameterValues("formTrechoVoo:selAeroportoOrigem");
		String[] selAeroportoDestino = req.getParameterValues("formTrechoVoo:selAeroportoDestino");
		String[] reservationtime = req.getParameterValues("formTrechoVoo:reservationtime");
		String[] preco = req.getParameterValues("formTrechoVoo:preco");
		for (int i = 0; i < qtdeTrechos; i++) {
			trecho = new Trecho();
			trecho.setAeroportoDestino(aeroportoDAO.searchByID(Integer.parseInt(selAeroportoDestino[i])));
			trecho.setAeroportoOrigem(aeroportoDAO.searchByID(Integer.parseInt(selAeroportoOrigem[i])));
			String[] chegadaPartida = reservationtime[i].split("-");
			trecho.setHorarioChegada(CalendarUtil.parseStringToCalendar(chegadaPartida[CHEGADA]));
			trecho.setHorarioPartida(CalendarUtil.parseStringToCalendar(chegadaPartida[PARTIDA]));
			trecho.setPreco(Double.parseDouble(preco[i]));
			voo.addTrecho(trecho);		
		}
	}

	private void populaCapacidades() {
		Classe classeEconomica = classeDAO.searchByID(CLASSE_ECONOMICA);
		Classe classeExecutiva = classeDAO.searchByID(CLASSE_EXECUTIVA);
		voo.addCapacidadeVoo(new CapacidadeVoo(qtdeAssentosEconomico, classeEconomica));
		voo.addCapacidadeVoo(new CapacidadeVoo(qtdeAssentosExecutivo, classeExecutiva));
	}
	
	public List<Trecho> getAllTrechos(){
		if(listaTrechos == null || listaTrechos.isEmpty()){
			listaTrechos = trechoDAO.findAll();
		}
		return this.listaTrechos;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public Integer getQtdeTrechos() {
		return qtdeTrechos;
	}

	public void setQtdeTrechos(Integer qtdeTrechos) {
		this.qtdeTrechos = qtdeTrechos;
	}

	public Integer getQtdeAssentosEconomico() {
		return qtdeAssentosEconomico;
	}

	public Integer getQtdeAssentosExecutivo() {
		return qtdeAssentosExecutivo;
	}

	public void setQtdeAssentosEconomico(Integer qtdeAssentosEconomico) {
		this.qtdeAssentosEconomico = qtdeAssentosEconomico;
	}

	public void setQtdeAssentosExecutivo(Integer qtdeAssentosExecutivo) {
		this.qtdeAssentosExecutivo = qtdeAssentosExecutivo;
	}

}
