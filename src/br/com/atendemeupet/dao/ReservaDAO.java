/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.dao;

import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Reserva;
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
public class ReservaDAO {

    private EntityManager em;

    public void inserirReserva(Reserva reserva) {
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
    }

    public void atualizarReserva(Reserva reserva) {
        em.getTransaction().begin();
        em.merge(reserva);
        em.getTransaction().commit();
    }

    public Reserva removerReserva(Reserva reserva) {
        em.getTransaction().begin();
        em.remove(reserva);
        em.getTransaction().commit();
        return reserva;
    }

    public List<Reserva> listarReservas() {
        Query query = em.createNamedQuery("ListarTodasAsReservas");

        List<Reserva> reservas = query.getResultList();

        return reservas;
    }

    public List<Reserva> listarReservas(int id) {
        Query query = em.createNamedQuery("ListarReservaId");

        query.setParameter("pId", id);

        List<Reserva> reservas = query.getResultList();

        return reservas;
    }

    public List<Reserva> listarReservas(Loja loja) {
        Query query = em.createNamedQuery("ListarReservasLoja");

        query.setParameter("pLoja", loja);

        List<Reserva> reservas = query.getResultList();

        return reservas;
    }

    public List<Reserva> listarReservas(Usuario usuario) {
        Query query = em.createNamedQuery("ListarReservasUsuario");

        query.setParameter("pUsuario", usuario);

        List<Reserva> reservas = query.getResultList();

        return reservas;
    }

}
