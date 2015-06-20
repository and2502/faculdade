package br.com.fiap.bean;

import java.io.Serializable;

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
				alunoBO.saveCurso(this.aluno);
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

	private void novoAluno() {
		this.aluno = new Aluno();
	}
	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
