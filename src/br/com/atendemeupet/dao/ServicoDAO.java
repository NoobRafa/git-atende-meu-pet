/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.dao;

import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Reserva;
import br.com.atendemeupet.entidades.Servico;
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
public class ServicoDAO {

    private EntityManager em;

    public void inserirServico(Servico servico) {
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
    }

    public void atualizarServico(Servico servico) {
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
    }

    public Servico removerServico(Servico servico) {
        em.getTransaction().begin();
        em.remove(servico);
        em.getTransaction().commit();
        return servico;
    }

    public List<Servico> listarServicos() {
        Query query = em.createNamedQuery("ListarTodosServicos");

        List<Servico> servicos = query.getResultList();

        return servicos;
    }
    
     public List<Servico> listarServicosLojas() {
        Query query = em.createNamedQuery("ListarServicosLojaGeral");

        List<Servico> servicos = query.getResultList();

        return servicos;
    }
    
    public List<Servico> listarServicos(int id) {
        Query query = em.createNamedQuery("ListarServicosId");
        
        query.setParameter("pId", id);

        List<Servico> servicos = query.getResultList();

        return servicos;
    }
    
    
    
    public List<Servico> listarServicos(String tipo) {
        Query query = em.createNamedQuery("ListarServicosTipo");
        
        query.setParameter("pTipo", tipo);

        List<Servico> servicos = query.getResultList();

        return servicos;
    }
    
    public List<Servico> listarServicos(Loja loja) {
        Query query = em.createNamedQuery("ListarServicosLoja");
        
        query.setParameter("pLoja", loja);

        List<Servico> servicos = query.getResultList();

        return servicos;
    }
    
      public List<Servico> listarServicos(Reserva reserva) {
        Query query = em.createNamedQuery("ListarServicosReserva");
        
        query.setParameter("pReserva", reserva);

        List<Servico> servicos = query.getResultList();

        return servicos;
    }


}
