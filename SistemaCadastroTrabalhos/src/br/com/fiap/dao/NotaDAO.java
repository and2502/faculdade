package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.config.DAO;
import br.com.fiap.entity.Nota;

public interface NotaDAO extends DAO<Nota, Long>{
	
	List<Nota> notas();

}
