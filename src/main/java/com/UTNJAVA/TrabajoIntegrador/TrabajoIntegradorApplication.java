package com.UTNJAVA.TrabajoIntegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import Entidades.Calificacion;
import Entidades.Cliente;
import Entidades.Prestador;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabajoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
	





	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaPU");
	EntityManager em = emf.createEntityManager();
 /*
	try{
		Cliente cli = new Cliente("Pepe", "Honguito", "1234");
		Prestador pres= new Prestador("Nico","soy","1234","Tarde","Informatica");
		cli.Calificar("8","Nose", pres);
                
                
                
		em.getTransaction().begin();
		em.persist(cli);
		em.flush();

		em.flush();
		em.getTransaction().commit();
		}
	catch(Exception E){
		em.getTransaction().rollback();
		E.getMessage();
	}
		em.close();
		emf.close();
	}*/ 
}
}
