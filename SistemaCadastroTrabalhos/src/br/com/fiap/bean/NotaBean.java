package br.com.fiap.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.entity.Nota;

@ManagedBean
@RequestScoped
public class NotaBean implements Serializable {

	private Nota nota;

	@PostConstruct
	public void inicializarObjetos() {
		nota = new Nota();
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
