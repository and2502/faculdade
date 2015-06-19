package br.com.fiap.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.entity.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaBean implements Serializable {

	private Disciplina disciplina;

	@PostConstruct
	public void inicializarObjetos() {
		disciplina = new Disciplina();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
