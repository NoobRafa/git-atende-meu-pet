/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.dao;

import br.com.atendemeupet.entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rafael Vieira
 */
@Getter
@Setter
@AllArgsConstructor
public class UsuarioDAO {

    private EntityManager em;

    public void inserirUsuario(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    public void atualizarUsuario(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    public Usuario removerUsuario(Usuario usuario) {
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    public List<Usuario> listarUsuarios() {

        Query query = em.createNamedQuery("ListarTodosOsUsuarios");

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuarios(String nome) {

        Query query = em.createNamedQuery("ListarUsuarioNome");

        query.setParameter("pNome", nome);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuarios(int id) {

        Query query = em.createNamedQuery("ListarUsuarioId");

        query.setParameter("pId", id);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuariosPets() {

        Query query = em.createNamedQuery("ListarUsuariosPets");

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuarioPets(int id) {

        Query query = em.createNamedQuery("ListarUsuarioIdPets");
        query.setParameter("pId", id);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }
    
    public List<Usuario> listarUsuarioPets(String nome) {

        Query query = em.createNamedQuery("ListarUsuarioNomePets");
        query.setParameter("pNome", nome);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuariosReservas() {

        Query query = em.createNamedQuery("ListarTodosUsuariosReservas");

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuarioReservas(int id) {

        Query query = em.createNamedQuery("ListarUsuarioIdReservas");

        query.setParameter("pId", id);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

    public List<Usuario> listarUsuariosReservas(String nome) {

        Query query = em.createNamedQuery("ListarUsuarioNomeReservas");

        query.setParameter("pNome", nome);

        @SuppressWarnings("unchecked")
        List<Usuario> usrs = query.getResultList();
        return usrs;
    }

}
