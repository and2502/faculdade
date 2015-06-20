package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.config.DAO;
import br.com.fiap.entity.Disciplina;

public interface DisciplinaDAO extends DAO<Disciplina, Long>{

	List<Disciplina> findDisciplinasByCurso(Long idCurso);
}
