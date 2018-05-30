/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.dao;

import br.com.atendemeupet.entidades.Pet;
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
public class PetDAO {

    private EntityManager em;

    public void inserirPet(Pet pet) {
        em.getTransaction().begin();
        em.persist(pet);
        em.getTransaction().commit();
    }

    public void atualizarPet(Pet pet) {
        em.getTransaction().begin();
        em.merge(pet);
        em.getTransaction().commit();
    }

    public Pet removerPet(Pet pet) {
        em.getTransaction().begin();
        em.remove(pet);
        em.getTransaction().commit();
        return pet;
    }

    public List<Pet> listarPets(){
        Query query = em.createNamedQuery("ListarTodosOsPets");
        
        List<Pet> pets = query.getResultList();
        
        return pets;
    }
    
    public List<Pet> listarPets(String nome){
        Query query = em.createNamedQuery("ListarPetNome");
        
        query.setParameter("pNome", nome);
        
        List<Pet> pets = query.getResultList();
        
        return pets;
    }
    
    public List<Pet> listarPets(Usuario usuario){
        Query query = em.createNamedQuery("ListarTodosOsPetsDoUsuario");
        
        query.setParameter("pUsuario", usuario);
        
        List<Pet> pets = query.getResultList();
        
        return pets;
    }

}
