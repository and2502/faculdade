package br.com.reserva.aerea.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import br.com.reserva.aerea.dao.ClienteDAO;
import br.com.reserva.aerea.entity.Cliente;
import br.com.reserva.aerea.entity.Login;

@ManagedBean(name="clienteBean")
public class ClienteBean extends AbstractBean implements Serializable {

	private static final char NAO = 'N';

	private static final long serialVersionUID = 1L;
	
	private UIInput senhaInput;
	private String repeteSenha;

	@EJB
	private ClienteDAO clienteDAO;

	private Cliente cliente;

	@PostConstruct
	public void inicializar() {
		cliente = new Cliente();
		cliente.setLogin(new Login());
	}
	
	public String registrar(){
		String url = "/xhtml/public/registre-se.xhtml";
		try{
			this.cliente.getLogin().setAdmin(NAO);
			clienteDAO.insert(this.cliente);
			url = "/xhtml/login.xhtml?faces-redirect=true";
		}catch(Exception e){
			addMessage("error","Não foi possivel registrar o cliente, contato o administrador!");
			e.printStackTrace();
		}
		
		return url;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getRepeteSenha() {
		return repeteSenha;
	}

	public void setRepeteSenha(String repeteSenha) {
		this.repeteSenha = repeteSenha;
	}
	
	// Get e Set  
	public UIInput getSenhaInput() {  
	    return senhaInput;  
	}  
	  
	public void setSenhaInput(UIInput senhaInput) {  
	    this.senhaInput = senhaInput;  
	}  

	public void validateSenha(FacesContext context, UIComponent toValidate, Object value) {  
	      
	    String confirmaSenha = (String) value;
	    String senha = (String)this.senhaInput.getLocalValue();
	    System.out.println("conf="+confirmaSenha+" == "+senha);
	    if (!confirmaSenha.equals(senha)) {  
	        ((UIInput)toValidate).setValid(false);  
	  
	        addMessage("msgs","A confirmação da senha não confere!");
	    }  
	}   

}
