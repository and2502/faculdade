package br.com.fiap.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaBean implements Serializable {

	private Disciplina disciplina;

	@PostConstruct
	public void inicializarObjetos() {
		novaDisciplina();
	}

	public void insert() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {
			CursoBO cursoBO = new CursoBO(em);
			if (cursoBO.verifyHasCursos()) {
				Curso curso = cursoBO.findCursoById(this.disciplina.getCurso()
						.getId());
				this.disciplina.setCurso(curso);
				cursoBO.saveDisciplina(this.disciplina);
				msg = new FacesMessage("Aviso:",
						"Disciplina inserido com sucesso!");
				novaDisciplina();
			} else {
				msg = new FacesMessage(
						"Aviso:",
						"Não existe nenhum curso cadastro! Portanto, não conseguirá concluir este cadastro.");
			}
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:",
					"Ocorreu uma falha ao tentar inserir a Disciplina!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}

	private void novaDisciplina() {
		this.disciplina = new Disciplina();
		this.disciplina.setCurso(new Curso());
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
