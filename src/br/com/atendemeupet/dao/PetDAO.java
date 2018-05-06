package br.com.atendemeupet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atendemeupet.entidades.Pet;
import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.util.JpaUtil;

public class PetDAO {

	public void inserirPet(Pet pet) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.persist(pet);
		em.getTransaction().commit();
		em.close();

	}

	public Pet removerPet(Pet pet) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(pet));
		em.getTransaction().commit();
		em.close();

		return pet;
	}

	public void atualizarPet(Pet pet) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.merge(pet);
		em.getTransaction().commit();
		em.close();

	}

	public List<Pet> listarPets() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosOsPets");

		@SuppressWarnings("unchecked")
		List<Pet> pets = query.getResultList();

		em.close();

		return pets;
	}

	public List<Pet> listarPets(Usuario usr) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosOsPetsDoUsuario");

		query.setParameter("pUsuario", usr);

		@SuppressWarnings("unchecked")
		List<Pet> pets = query.getResultList();

		em.close();
		return pets;
	}

	public List<Pet> listarPets(String nome) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarPetNome");

		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Pet> pets = query.getResultList();

		em.close();
		return pets;
	}
}
