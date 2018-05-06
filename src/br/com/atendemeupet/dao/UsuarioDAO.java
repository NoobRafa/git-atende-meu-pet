package br.com.atendemeupet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.util.JpaUtil;

public class UsuarioDAO {

	public void inserirUsuario(Usuario usr) {

		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.persist(usr);
		em.getTransaction().commit();
		em.close();

	}

	public Usuario removerUsuario(Usuario usr) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(usr));
		em.getTransaction().commit();
		em.close();

		return usr;
	}

	public void atualizarUsuario(Usuario usr) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		em.getTransaction().begin();
		em.merge(usr);
		em.getTransaction().commit();
		em.close();

	}

	public List<Usuario> listarUsuarios() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosOsUsuarios");

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuarios(String nome) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioNome");
		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuarios(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioId");
		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuariosPets() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioPets");

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuariosLojas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuariosLojas");

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuarioLojas(String nome) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioLojas");

		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarTodosUsuariosReservas() {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarTodosUsuariosReservas");

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuarioIdReservas(int id) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioIdReservas");

		query.setParameter("pId", id);

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}

	public List<Usuario> listarUsuarioNomeReservas(String nome) {
		EntityManager em = JpaUtil.getFACTORY().createEntityManager();

		Query query = em.createNamedQuery("ListarUsuarioNomeReservas");

		query.setParameter("pNome", nome);

		@SuppressWarnings("unchecked")
		List<Usuario> usrs = query.getResultList();
		em.close();
		return usrs;
	}
}
