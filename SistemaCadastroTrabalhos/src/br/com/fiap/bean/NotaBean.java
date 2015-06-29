package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;

import br.com.fiap.bo.NotaBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Nota;

@ManagedBean
@ViewScoped
public class NotaBean implements Serializable {

	private Nota nota;
	private List<Nota> notas;
	
	@PostConstruct
	public void inicializarObjetos() {
		nota = new Nota();
		notas = new ArrayList<Nota>();
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	public void buscarNotasAlunos(AjaxBehaviorEvent event){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			
			NotaBO notaBO = new NotaBO(em);
			if(notas.isEmpty() || notas.size() == 0 || notas == null)
				notas = notaBO.findAllNotas();
			
			msg = new FacesMessage("Aviso", "Busca de notas dos alunos efetuado com sucesso");
		} catch (Exception e) {
			msg = new FacesMessage("Aviso", "Erro na busca de lista de notas dos alunos");
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		fc.addMessage("", msg);
	}

}
