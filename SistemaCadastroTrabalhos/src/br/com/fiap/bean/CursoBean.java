package br.com.fiap.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Curso;

@ManagedBean(name="cursoBean")
@RequestScoped
public class CursoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void insert(){
		  FacesContext fc = FacesContext.getCurrentInstance();
		  FacesMessage msg = null;
		  EntityManager em = JPAUtil.getEntityManager();
		  try{
		      new CursoBO(em).saveCurso(this.curso);
		      msg = new FacesMessage("Curso inserido com sucesso!");
		      this.curso = new Curso();
		  }catch(Exception ex){
			  msg = new FacesMessage("Ocorreu uma falha ao tentar inserir o curso!");
		      ex.printStackTrace();
		  }finally{
		      em.close();
		  }
		  fc.addMessage("", msg);
	}
	

    public void findAllCursos(){
      // TODO IMPLEMENTAR A LISTAGEM DE CURSOS
    }
    
    public void findAllAlunosByCurso(){
      // TODO IMPLEMENTAR A LISTAGEM DE ALUNOS POR CURSO SELECIONADO
    }
}
