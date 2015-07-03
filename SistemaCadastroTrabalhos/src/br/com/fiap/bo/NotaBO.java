package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.NotaDAO;
import br.com.fiap.dao.impl.NotaDAOImpl;
import br.com.fiap.entity.Nota;

public class NotaBO {
	
	private NotaDAO dao;
	
	public NotaBO(EntityManager em){
		dao = new NotaDAOImpl(em);
	}
	
	public List<Nota> findAllNotas(){
		return dao.notas();
	}

}
