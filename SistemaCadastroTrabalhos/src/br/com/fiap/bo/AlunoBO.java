package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.CursoAlunoDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.dao.impl.CursoAlunoDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.CursoAluno;

public class AlunoBO {

	private AlunoDAO alunoDAO;
	private CursoAlunoDAO cursoAlunoDAO;

	public AlunoBO(EntityManager em) {
		alunoDAO = new AlunoDAOImpl(em);
		cursoAlunoDAO = new CursoAlunoDAOImpl(em);
	}

	public void saveAluno(Aluno aluno) {
		alunoDAO.insert(aluno);
	}
	
	public void saveCursoAluno(CursoAluno cursoAluno){
		cursoAlunoDAO.insert(cursoAluno);
	}
	
	public void updateAluno(Aluno aluno){
		alunoDAO.update(aluno);
	}

	public Aluno findAlunoById(Long id) {
		return alunoDAO.searchByID(id);
	}

	public List<Aluno> findAllAlunos() {
		return alunoDAO.findAllAlunos();
	}

}
