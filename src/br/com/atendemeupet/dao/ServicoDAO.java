package br.com.atendemeupet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atendemeupet.entidades.Servico;
import br.com.atendemeupet.util.JpaUtil;

public class ServicoDAO {
	public void inserirServico(Servico servico) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.persist(servico);
		em.getTransaction().commit();
		em.close();

	}

	public Servico removerServico(Servico servico) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(servico));
		em.getTransaction().commit();
		em.close();

		return servico;
	}

	public void atualizarServico(Servico servico) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.merge(servico);
		em.getTransaction().commit();
		em.close();

	}

	public List<Servico> listarServicos() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosOsServicos");

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();
		em.close();
		return servicos;
	}

	public List<Servico> listarTodosOsServicosLojas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosOsServicosLojas");

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();
		em.close();
		return servicos;
	}

	public List<Servico> listarServicos(String tipo) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarServicoTipo");
		query.setParameter("pTipo", tipo);

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();

		em.close();

		return servicos;
	}

	public List<Servico> listarServicos(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarServicoId");
		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();
		
		em.close();
		return servicos;
	}

	public List<Servico> listarServicosReservas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarServicosReservas");

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();
		em.close();
		return servicos;
	}

	public List<Servico> listarTipoServicoReservas(String tipo) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTipoServicoReservas");

		query.setParameter("pTipo", tipo);

		@SuppressWarnings("unchecked")
		List<Servico> servicos = query.getResultList();
		em.close();
		return servicos;
	}

}
