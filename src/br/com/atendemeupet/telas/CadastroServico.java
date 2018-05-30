/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.telas;

import br.com.atendemeupet.dao.ServicoDAO;
import br.com.atendemeupet.entidades.Servico;
import br.com.atendemeupet.exceptions.CampoException;
import br.com.atendemeupet.exceptions.EntidadeException;
import br.com.atendemeupet.util.JpaUtil;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Vieira
 */
public class CadastroServico extends javax.swing.JInternalFrame {

    private static CadastroServico cadastroServico;

    private ServicoDAO dao = new ServicoDAO(JpaUtil.getEM());

    @Override
    public void dispose() {
        cadastroServico = null;
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    private void limpar(List<JComponent> unit) {
        for (JComponent jComponent : unit) {
            if (jComponent instanceof JTextField) {
                ((JTextField) jComponent).setText(null);
            }

            if (jComponent instanceof JFormattedTextField) {
                ((JFormattedTextField) jComponent).setValue(null);
                ((JFormattedTextField) jComponent).setText(null);
            }
        }
    }

    private void continuar() {
        OUTER:
        while (true) {
            String resposta = JOptionPane.showInputDialog("Deseja continuar cadastrando? [S/N]");

            if (resposta == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
                dispose();
                break;
            }

            switch (resposta) {
                case "S":
                    limpar(Arrays.asList(tipo));
                    break OUTER;
                case "N":
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                    dispose();
                    break OUTER;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! - Tente usar S ou N.");

            }
        }
    }

    private CadastroServico() {
        initComponents();

    }

    public static CadastroServico getInstance() {
        if (cadastroServico == null) {
            cadastroServico = new CadastroServico();
        }
        return cadastroServico;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cadastrar = new javax.swing.JButton();
        tipo = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de Serviço");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("TIPO: ");

        cadastrar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cadastrar.setText("CADASTRAR");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(cadastrar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        // TODO add your handling code here:
        try {
            if (tipo.getText().length() < 5 || tipo.getText().isEmpty()) {
                tipo.setText(null);
                throw new CampoException("Verifique o campo: Tipo !");
            }

            Servico servico = new Servico(tipo.getText());

            List<Servico> listaServicos = dao.listarServicos();

            if (listaServicos.isEmpty()) {
                dao.inserirServico(servico);
                JOptionPane.showMessageDialog(null, "Servico Cadastrado com sucesso! ");
                continuar();
            } else {
                for (Servico listaServico : listaServicos) {
                    if (servico.equals(listaServico)) {
                        throw new EntidadeException("Esse Servico já foi cadastrado!");
                    }
                }
                dao.inserirServico(servico);
                JOptionPane.showMessageDialog(null, "Servico Cadastrado com sucesso! ");
                continuar();

            }

        } catch (CampoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (EntidadeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            continuar();
        }

    }//GEN-LAST:event_cadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables

}
