package br.com.fiap.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Curso;

@ManagedBean(name="cursoBean")
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
	  EntityManager em = JPAUtil.getEntityManager();
	  try{
	      new CursoBO(em).saveCurso(this.curso);
	  }catch(Exception ex){
	      ex.printStackTrace();
	  }finally{
	      em.close();
	  }
	}
	

    public void findAllCursos(){
      // TODO IMPLEMENTAR A LISTAGEM DE CURSOS
    }
    
    public void findAllAlunosByCurso(){
      // TODO IMPLEMENTAR A LISTAGEM DE ALUNOS POR CURSO SELECIONADO
    }
}
