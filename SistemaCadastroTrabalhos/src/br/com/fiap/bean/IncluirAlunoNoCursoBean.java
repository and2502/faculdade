package br.com.fiap.bean;

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
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.CursoAluno;

@ManagedBean
@RequestScoped
public class IncluirAlunoNoCursoBean {

	private Aluno aluno;
	private Curso curso;
	
	@PostConstruct
	public void inicilizar(){
		novoAlunoNoCurso();
	}

	private void novoAlunoNoCurso() {
		this.aluno = new Aluno();
		this.curso = new Curso();
	}
	
	public void incluirAlunoNoCurso() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {
			AlunoBO alunoBO = new AlunoBO(em);
			CursoBO cursoBO = new CursoBO(em);
			this.aluno = alunoBO.findAlunoById(this.aluno.getId());
			this.curso = cursoBO.findCursoById(this.curso.getId());
			CursoAluno cursoAluno = new CursoAluno();
			cursoAluno.setAluno(aluno);
			cursoAluno.setCurso(curso);
			alunoBO.saveCursoAluno(cursoAluno);
			msg = new FacesMessage("Aviso:", this.aluno.getNome() + " foi incluido com sucesso no curso "+this.curso.getNome()+ "!");
			novoAlunoNoCurso();
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:",
					"Ocorreu uma falha ao tentar inserir o aluno no curso!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
