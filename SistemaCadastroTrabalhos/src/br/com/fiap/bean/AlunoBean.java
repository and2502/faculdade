package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Aluno;

@ManagedBean
@RequestScoped
public class AlunoBean implements Serializable{

	private Aluno aluno;
	private List<Aluno> listaAlunos;

	@PostConstruct
	public void inicializarObjetos() {
		aluno = new Aluno();
	}
	
	public void insert() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {
			CursoBO cursoBO = new CursoBO(em);
			AlunoBO alunoBO = new AlunoBO(em);
			if(cursoBO.verifyHasCursos()){
				alunoBO.saveAluno(this.aluno);
				msg = new FacesMessage("Aviso:", "Aluno inserido com sucesso!");
				novoAluno();
			}else{
				msg = new FacesMessage("Aviso:", "Não existe nenhum curso cadastro! Portanto, não conseguirá concluir este cadastro.");
			}
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:","Ocorreu uma falha ao tentar inserir o Aluno!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}
	
	public void findAllAlunos() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			this.listaAlunos = new AlunoBO(em).findAllAlunos();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	private void novoAluno() {
		this.aluno = new Aluno();
	}
	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListaAlunos() {
		if(this.listaAlunos == null){
			findAllAlunos();
		}
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
}
