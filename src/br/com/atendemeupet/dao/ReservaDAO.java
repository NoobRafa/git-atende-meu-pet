package br.com.atendemeupet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Reserva;
import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.util.JpaUtil;

public class ReservaDAO {

	public void inserirReserva(Reserva reserva) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();

	}

	public Reserva removerReserva(Reserva reserva) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(reserva));
		em.getTransaction().commit();
		em.close();

		return reserva;
	}

	public void atualizarReserva(Reserva reserva) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.merge(reserva);
		em.getTransaction().commit();
		em.close();

	}

	public List<Reserva> listarReservas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodasAsReservas");

		@SuppressWarnings("unchecked")
		List<Reserva> reservas = query.getResultList();

		em.close();

		return reservas;
	}

	public List<Reserva> listarReservas(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarReservaId");

		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Reserva> reservas = query.getResultList();

		em.close();

		return reservas;
	}

	public List<Reserva> listarReservas(Loja loja) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarReservasLoja");

		query.setParameter("pLoja", loja);

		@SuppressWarnings("unchecked")
		List<Reserva> reservas = query.getResultList();

		em.close();

		return reservas;
	}

	public List<Reserva> listarReservas(Usuario usr) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarReservasUsuario");

		query.setParameter("pUsuario", usr);

		@SuppressWarnings("unchecked")
		List<Reserva> reservas = query.getResultList();

		em.close();

		return reservas;
	}

}
