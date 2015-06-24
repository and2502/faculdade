package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.bo.CursoBO;
import br.com.fiap.config.JPAUtil;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;

@ManagedBean(name = "alunoBean")
@ViewScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private List<Aluno> listaAlunos;
	private List<Aluno> listaAlunosByCurso;
	private List<Disciplina> listaDisciplinaByCurso;
	private Nota nota;
	private Long idCurso;
	private Long idDisciplina;
	private Long idAluno;

	@PostConstruct
	public void inicializarObjetos() {
		aluno = new Aluno();
		nota = new Nota();
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
				msg = new FacesMessage("Aviso:", "NÃ£o existe nenhum curso cadastro! Portanto, nÃ£o conseguirÃ¡ concluir este cadastro.");
			}
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:","Ocorreu uma falha ao tentar inserir o Aluno!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}
	
	public void insertNotaAluno() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {
			CursoBO cursoBO = new CursoBO(em);
			AlunoBO alunoBO = new AlunoBO(em);
			nota.setAluno(alunoBO.findAlunoById(idAluno));
			nota.setDisciplina(cursoBO.findDisciplinaById(idDisciplina));
			cursoBO.saveNota(this.nota);
			msg = new FacesMessage("Aviso:", "Nota inserida com sucesso!");
		} catch (Exception ex) {
			msg = new FacesMessage("Aviso:","Ocorreu uma falha ao tentar inserir a nota!");
			ex.printStackTrace();
		} finally {
			em.close();
		}
		fc.addMessage("", msg);
	}
	
	/**
	 * método tem a finalidade de receber o id do Aluno pela requisição da view e valorizar uma variavel do tipo Long
	 * 	
	 * @param idAlun - variavel do tipo Long, representa id do usuário seleciona em requisição da View
	 */
	public void preencherCodigoAluno(Long idAlun){
		idAluno = idAlun;
	}	
	
	public void findAllAlunosByCurso() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			this.listaAlunosByCurso = new AlunoBO(em).findAllAlunosByCurso(this.idCurso);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
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
	
	public void findDisciplinasByCurso() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			this.listaDisciplinaByCurso = new CursoBO(em).findDisciplinasByCurso(this.idCurso);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public List<Disciplina> getListaDisciplinaByCurso() {
		if(this.listaDisciplinaByCurso == null){
			this.listaDisciplinaByCurso = new ArrayList<Disciplina>();
		}
		return listaDisciplinaByCurso;
	}

	public void setListaDisciplinaByCurso(List<Disciplina> listaDisciplinaByCurso) {
		this.listaDisciplinaByCurso = listaDisciplinaByCurso;
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

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public List<Aluno> getListaAlunosByCurso() {
		if(this.listaAlunosByCurso == null){
			this.listaAlunosByCurso = new ArrayList<Aluno>();
		}
		return listaAlunosByCurso;
	}

	public void setListaAlunosByCurso(List<Aluno> listaAlunosByCurso) {
		this.listaAlunosByCurso = listaAlunosByCurso;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
