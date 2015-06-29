package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.NotaDAO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;

public class NotaDAOImpl extends DAOImpl<Nota, Long> implements NotaDAO{

	public NotaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Nota> notas() {
		
		Query query = em.createNativeQuery("select a.id as idAluno, a.RM, a.NOME as nAluno, c.id as idCurso, c.NOME as nCurso, d.id as idDisciplina, d.NOME as dDisciplina, n.VALOR "
				+ 							"from sistemacadtrabalhos.aluno a, sistemacadtrabalhos.curso_aluno ca, sistemacadtrabalhos.curso c, sistemacadtrabalhos.disciplina d, sistemacadtrabalhos.nota n "
				+                           "where ca.ALUNO_ID = ca.CURSO_ID AND d.CURSO_ID = c.ID AND n.disciplina_ID = d.ID AND n.aluno_ID = a.ID "
				+                           "group by a.RM, nAluno, nCurso, dDisciplina, n.VALOR");		
		
		List<Object[]> objs = query.getResultList();
		
		Disciplina dis = new Disciplina();
		Aluno alu = new Aluno();
		int count = 0;
		for (Object[] objects : objs) {
			
			alu.setId((Long) objects[count]);
			alu.setRm((String) objects[count]);
			alu.setNome((String) objects[count]);
			
			
			
			++count;
		}
		
		/*for (int i = 0; i < objs.size(); i++) {
			
			alu.setId((Long) objs.get(i)[i]);
			alu.setRm((String) objs.get(i)[i]);
			alu.setNome((String) objs.get(i)[i]);
			
		}*/
		
		return query.getResultList();
	}
	

}
