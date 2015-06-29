package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.config.DAO;
import br.com.fiap.entity.Curso;

public interface CursoDAO extends DAO<Curso, Long>{

	List<Curso> findAllCursos();
	
	boolean verifyHasCursos();

}
