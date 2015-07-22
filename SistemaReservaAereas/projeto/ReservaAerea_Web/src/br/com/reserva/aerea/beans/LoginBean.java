package br.com.reserva.aerea.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.reserva.aerea.dao.LoginDAO;
import br.com.reserva.aerea.entity.Login;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean extends AbstractBean implements Serializable{

	private static final char SIM = 'S';

	private static final long serialVersionUID = 1L;

	@EJB
	private LoginDAO loginDAO;
	
	private Login login;
	
	private Login usuarioLogado = null;
	
	
	@PostConstruct
	private void init(){
		login = new Login();
	}
	
	public String logar(){
		HttpServletRequest request = getHttpServletRequest();
			String url = (String) request.getSession().getAttribute("redirectTo");
			if(url == null){
				url = "/xhtml/index.xhtml";
			}
			Login usuarioCarregado = loginDAO.autenticar(login.getUsuario(), login.getSenha());
			this.usuarioLogado = usuarioCarregado;
			if(isLoggedUsuario()){
				request.getSession().removeAttribute("redirectTo");
				return url + "?faces-redirect=true";
			}
			addMessage("msgs","Úsuario ou senha invalida!");
		return null;
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/xhtml/login.xhtml?faces-redirect=true";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Login usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isLoggedUsuario(){
		return usuarioLogado != null;
	}
	
	public boolean isAdminUsuario(){
		return isLoggedUsuario() && usuarioLogado.getAdmin() == SIM;
	}
	
	public String getDateNow(){
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(now.getTime());
	}
}
