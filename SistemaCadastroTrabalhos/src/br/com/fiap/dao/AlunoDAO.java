package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.config.DAO;
import br.com.fiap.entity.Aluno;

public interface AlunoDAO extends DAO<Aluno, Long>{

	List<Aluno> findAllAlunos();

}
