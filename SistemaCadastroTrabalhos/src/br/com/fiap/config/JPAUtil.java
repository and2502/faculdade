package br.com.fiap.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("sistemaCadTrabalhos");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}