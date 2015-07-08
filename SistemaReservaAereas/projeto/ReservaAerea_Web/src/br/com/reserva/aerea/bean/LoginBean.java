package br.com.reserva.aerea.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.reserva.aerea.dao.LoginDAO;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	@EJB
	private LoginDAO loginDAO;
	
	@PostConstruct
	private void init(){
	}
	
}
