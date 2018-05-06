package br.com.atendemeupet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.util.JpaUtil;

public class LojaDAO {
	public void inserirLoja(Loja loja) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.persist(loja);
		em.getTransaction().commit();
		em.close();

	}

	public Loja removerLoja(Loja loja) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(loja));
		em.getTransaction().commit();
		em.close();

		return loja;
	}

	public void atualizarLoja(Loja loja) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.merge(loja);
		em.getTransaction().commit();
		em.close();

	}

	public List<Loja> listarLojas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodasAsLojas");

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

	public List<Loja> listarLojas(Usuario usr) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojaUsuario");

		query.setParameter("pUsuario", usr);

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

	public List<Loja> listarLojas(String nome) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojaNome");

		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

	public List<Loja> listarLojas(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojaId");

		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

	public List<Loja> listarLojasServicos() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojasServicos");

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

	public List<Loja> listarLojasUsuario() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();
		Query query = em.createNamedQuery("ListarLojasUsuario");
		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}
	
	public List<Loja> listarLojaReservas(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojaIdReservas");

		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}
	
	public List<Loja> listarLojaReservas(String nome) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarLojaNomeReservas");

		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}
	
	public List<Loja> listarLojasReservas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();
		Query query = em.createNamedQuery("ListarLojasReservas");
		@SuppressWarnings("unchecked")
		List<Loja> lojas = query.getResultList();
		em.close();
		return lojas;
	}

}
