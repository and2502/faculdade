package br.com.fiap.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.fiap.entity.Curso;

@ManagedBean(name="cursoBean")
public class CursoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
