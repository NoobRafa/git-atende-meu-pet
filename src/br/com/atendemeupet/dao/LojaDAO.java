/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.dao;

import br.com.atendemeupet.entidades.Loja;
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
public class LojaDAO {

    private EntityManager em;

    public void inserirLoja(Loja loja) {
        em.getTransaction().begin();
        em.persist(loja);
        em.getTransaction().commit();
    }

    public void atualizarLoja(Loja loja) {
        em.getTransaction().begin();
        em.merge(loja);
        em.getTransaction().commit();
    }

    public Loja removerLoja(Loja loja) {
        em.getTransaction().begin();
        em.remove(loja);
        em.getTransaction().commit();
        return loja;
    }

    public List<Loja> listarLojas() {
        Query query = em.createNamedQuery("ListarTodasAsLojas");

        List<Loja> lojas = query.getResultList();

        return lojas;
    }

    public List<Loja> listarLojas(int id) {
        Query query = em.createNamedQuery("ListarLojaId");

        query.setParameter("pId", id);

        List<Loja> lojas = query.getResultList();

        return lojas;
    }

    public List<Loja> listarLojas(String razaoSocial) {
        Query query = em.createNamedQuery("ListarLojaRazaoSocial");

        query.setParameter("pRazaoSocial", razaoSocial);

        List<Loja> lojas = query.getResultList();

        return lojas;
    }

    public List<Loja> listarLojasReservas() {

        Query query = em.createNamedQuery("ListarLojasReservas");

        List<Loja> lojas = query.getResultList();

        return lojas;

    }
    
    public List<Loja> listarLojasServicos() {

        Query query = em.createNamedQuery("ListarLojasServicos");

        List<Loja> lojas = query.getResultList();

        return lojas;

    }
    
    public List<Loja> listarLojaPeloServico(String tipo){
         Query query = em.createNamedQuery("ListarLojaPeloServico");

        query.setParameter("pTipo", tipo);

        List<Loja> lojas = query.getResultList();

        return lojas;
    }

}
