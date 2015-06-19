package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.entity.Aluno;


public class AlunoBO{

  private AlunoDAO alunoDAO;
  
  public AlunoBO(EntityManager em){
    alunoDAO = new AlunoDAOImpl(em);
  }

  public void saveCurso(Aluno aluno){
    alunoDAO.insert(aluno);
  }
}
