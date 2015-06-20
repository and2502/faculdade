package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Curso;

@ManagedBean(name = "cursoBean")
@RequestScoped
public class CursoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();
	private List<Curso> listaCursos;

	@PostConstruct
	public void inicializaRecursos() {

	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void insert() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {
			new CursoBO(em).saveCurso(this.curso);
			msg = new FacesMessage("Aviso:", "Curso inserido com sucesso!");
			novoCurso();
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:",
					"Ocorreu uma falha ao tentar inserir o curso!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}
	
	private void novoCurso() {
		this.curso = new Curso();
	}

	public void findAllCursos() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			this.listaCursos = new CursoBO(em).findAllCursos();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void findAllAlunosByCurso() {
		// TODO IMPLEMENTAR A LISTAGEM DE ALUNOS POR CURSO SELECIONADO
	}

	public List<Curso> getListaCursos() {
		if(this.listaCursos == null){
			findAllCursos();
		}
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
}
