/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.testes;

import br.com.atendemeupet.dao.ServicoDAO;
import br.com.atendemeupet.dao.UsuarioDAO;
import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Pet;
import br.com.atendemeupet.entidades.Servico;
import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.util.JpaUtil;

/**
 *
 * @author Rafael Vieira
 */
public class Teste {

    public static void main(String[] args) {
//        ServicoDAO sdao = new ServicoDAO(JpaUtil.getEM());
//        
//        
//        for (Servico listarServicosLoja : sdao.listarServicosLojas()) {
//            System.out.println(listarServicosLoja);
//            for (Loja loja : listarServicosLoja.getLojas()) {
//                System.out.println(loja);
//            }
//        }
          UsuarioDAO udao = new UsuarioDAO(JpaUtil.getEM());
          
          
          for (Usuario listarUsuario : udao.listarUsuarios("rafaela")) {
              System.out.println(listarUsuario);
              for (Pet pet : listarUsuario.getPets()) {
                  System.out.println(pet);
              }
        }
    }

}
