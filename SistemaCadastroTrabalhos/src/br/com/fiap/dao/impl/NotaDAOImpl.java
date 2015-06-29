package br.com.fiap.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.NotaDAO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
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
		List<Nota> notas = new ArrayList<Nota>();
				
		for (Object[] objects : objs) {
			
			Disciplina dis = new Disciplina();
			Aluno alu = new Aluno();
			Curso cur = new Curso();
			Nota not = new Nota();			
			alu.setId(Long.valueOf(objects[0].toString()));
			alu.setRm((String) objects[1]);
			alu.setNome((String) objects[2]);
						
			cur.setId(Long.valueOf(objects[3].toString()));
			cur.setNome((String) objects[4]);
						
			dis.setId(Long.valueOf(objects[5].toString()));
			dis.setNome((String) objects[6]);
			dis.setCurso(cur);
			
			not.setValor((Double) objects[7]);
			not.setAluno(alu);
			not.setDisciplina(dis);
			
			notas.add(not);					
		}
				
		return notas;
	}
	

}
