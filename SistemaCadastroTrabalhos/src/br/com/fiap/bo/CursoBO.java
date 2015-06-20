package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.dao.NotaDAO;
import br.com.fiap.dao.impl.CursoDAOImpl;
import br.com.fiap.dao.impl.DisciplinaDAOImpl;
import br.com.fiap.dao.impl.NotaDAOImpl;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;

public class CursoBO{
	
	private CursoDAO cursoDAO;
	private DisciplinaDAO disciplinaDAO;
	private NotaDAO notaDAO;
	
	public CursoBO(EntityManager em){
		cursoDAO = new CursoDAOImpl(em);
		disciplinaDAO = new DisciplinaDAOImpl(em);
		notaDAO = new NotaDAOImpl(em);
	}
	
	public Curso findCursoById(Long id){
		return cursoDAO.searchByID(id);
	}

	public void saveCurso(Curso curso){
		cursoDAO.insert(curso);
	}
	
	public void saveDisciplina(Disciplina disciplina){
		disciplinaDAO.insert(disciplina);
	}
	
	public void saveNota(Nota nota){
		notaDAO.insert(nota);
	}
	
	public List<Curso> findAllCursos(){
		return cursoDAO.findAllCursos();
	}
	
	public boolean verifyHasCursos(){
		return cursoDAO.verifyHasCursos();
	}
}
