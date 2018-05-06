package br.com.atendemeupet.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {
	
	private static final String PERSISTENCE_UNIT = "database_pet";
	
	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	
	public static EntityManagerFactory getFACTORY(){
		return FACTORY;
	}
}
