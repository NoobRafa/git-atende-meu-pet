/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.telas;

import br.com.atendemeupet.dao.LojaDAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import br.com.atendemeupet.dao.UsuarioDAO;
import br.com.atendemeupet.entidades.Loja;
import br.com.atendemeupet.entidades.Usuario;
import br.com.atendemeupet.modelos.LojaTableModel;
import br.com.atendemeupet.modelos.UsuarioTableModel;
import br.com.atendemeupet.modelos.ReservaTableModel;
import br.com.atendemeupet.util.JpaUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Vieira
 */
public class Relatorios extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioUsuario
     */
    private static Relatorios relatorios;

    private UsuarioDAO daoUsuario = new UsuarioDAO(JpaUtil.getEM());
    private List<Usuario> listaUsuarios = daoUsuario.listarUsuariosReservas();
    private UsuarioTableModel modeloUsuario = new UsuarioTableModel(listaUsuarios);
    private Usuario usuario;

    private LojaDAO daoLoja = new LojaDAO(JpaUtil.getEM());
    private List<Loja> listaLojas = daoLoja.listarLojasReservas();
    private LojaTableModel modeloLoja = new LojaTableModel(listaLojas);
    private Loja loja;

    private Relatorios() {
        initComponents();
    }

    public static synchronized Relatorios getInstance() {
        if (relatorios == null) {
            relatorios = new Relatorios();
        }

        return relatorios;

    }

    @Override
    public void dispose() {
        usuario = null;
        loja = null;
        relatorios = null;
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
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
        nomeUsuario = new javax.swing.JTextField();
        buscarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        gerarRelatorioUsuario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaLoja = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nomeLoja = new javax.swing.JTextField();
        buscarLoja = new javax.swing.JButton();
        gerarRelatorioLoja = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatórios");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("USUÁRIOS:");

        buscarUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buscarUsuario.setText("BUSCAR");
        buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuarioActionPerformed(evt);
            }
        });

        tabelaUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tabelaUsuario.setModel(modeloUsuario);
        tabelaUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaUsuario);

        gerarRelatorioUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        gerarRelatorioUsuario.setText("GERAR RELATÓRIO DO USUÁRIO");
        gerarRelatorioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRelatorioUsuarioActionPerformed(evt);
            }
        });

        tabelaLoja.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tabelaLoja.setModel(modeloLoja);
        tabelaLoja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tabelaLoja);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("LOJAS: ");

        buscarLoja.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buscarLoja.setText("BUSCAR");
        buscarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLojaActionPerformed(evt);
            }
        });

        gerarRelatorioLoja.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        gerarRelatorioLoja.setText("GERAR RELATÓRIO DA LOJA");
        gerarRelatorioLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRelatorioLojaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(232, 232, 232)
                                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscarUsuario))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarLoja))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(gerarRelatorioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(gerarRelatorioLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarUsuario)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gerarRelatorioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarLoja)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gerarRelatorioLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuarioActionPerformed
        // TODO add your handling code here:
        if (!nomeUsuario.getText().isEmpty()) {
            List<Usuario> aux = daoUsuario.listarUsuarios(nomeUsuario.getText());

            if (!aux.isEmpty()) {
                modeloUsuario = new UsuarioTableModel(aux);
                tabelaUsuario.setModel(modeloUsuario);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario " + nomeUsuario.getText() + " não foi encontrado!");
                nomeUsuario.setText(null);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verifique o campo antes de tentar realizar uma busca!");
        }

    }//GEN-LAST:event_buscarUsuarioActionPerformed

    private void gerarRelatorioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarRelatorioUsuarioActionPerformed
        // TODO add your handling code here:
        if (tabelaUsuario.getSelectedRow() != -1) {

            usuario = modeloUsuario.getRow(tabelaUsuario.getSelectedRow());

            Font fonteTitulo = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
            Font corpoTexto = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);

            try {
                Document documento = new Document();

                File arquivo = new File("RelatorioDeReservas- " + usuario.getNome() + ".pdf");

                FileOutputStream saidaArquivo = new FileOutputStream(arquivo);

                PdfWriter.getInstance(documento, saidaArquivo);

                documento.open();
                ReservaTableModel modelo = new ReservaTableModel(usuario.getReservas());
                Phrase frase = new Phrase("ATENDE MEU PET!", fonteTitulo);
                Paragraph paragrafo = new Paragraph(frase);
                paragrafo.add(Chunk.NEWLINE);
                paragrafo.add(new Phrase("Relatório de Reservas do(a) usuario " + usuario.getNome(), corpoTexto));
                paragrafo.setAlignment(Element.ALIGN_CENTER);

                documento.add(paragrafo);

                documento.add(Chunk.NEWLINE);

                PdfPTable tabela = new PdfPTable(modelo.getColumnCount());

                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    tabela.addCell(modelo.getColumnName(i) + " ");
                }

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    for (int j = 0; j < modelo.getColumnCount(); j++) {
                        tabela.addCell(modelo.getValueAt(i, j).toString());
                    }
                }

                documento.add(tabela);

                documento.close();

                JOptionPane.showMessageDialog(null, "Relatório criado com sucesso! ");
                nomeUsuario.setText(null);
                dispose();

            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione primeiro um usuario para então gerar um relatório!");
        }
    }//GEN-LAST:event_gerarRelatorioUsuarioActionPerformed

    private void buscarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLojaActionPerformed
        // TODO add your handling code here:
        if (!nomeLoja.getText().isEmpty()) {
            List<Loja> aux = daoLoja.listarLojas(nomeLoja.getText());

            if (!aux.isEmpty()) {
                modeloLoja = new LojaTableModel(aux);
                tabelaLoja.setModel(modeloLoja);
            } else {
                JOptionPane.showMessageDialog(null, "Loja " + nomeLoja.getText() + " não foi encontrada!");
                nomeLoja.setText(null);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verifique o campo antes de tentar realizar uma busca!");
        }

    }//GEN-LAST:event_buscarLojaActionPerformed

    private void gerarRelatorioLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarRelatorioLojaActionPerformed
        // TODO add your handling code here:
        if (tabelaLoja.getSelectedRow() != -1) {

            loja = modeloLoja.getRow(tabelaLoja.getSelectedRow());

            Font fonteTitulo = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
            Font corpoTexto = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);

            try {
                Document documento = new Document();

                File arquivo = new File("RelatorioDeReservas- " + loja.getRazaoSocial() + ".pdf");

                FileOutputStream saidaArquivo = new FileOutputStream(arquivo);

                PdfWriter.getInstance(documento, saidaArquivo);

                documento.open();
                ReservaTableModel modelo = new ReservaTableModel(loja.getReservas());
                Phrase frase = new Phrase("ATENDE MEU PET!", fonteTitulo);
                Paragraph paragrafo = new Paragraph(frase);
                paragrafo.add(Chunk.NEWLINE);
                paragrafo.add(new Phrase("Relatório de Reservas da loja " + loja.getRazaoSocial(), corpoTexto));
                paragrafo.setAlignment(Element.ALIGN_CENTER);

                documento.add(paragrafo);

                documento.add(Chunk.NEWLINE);

                PdfPTable tabela = new PdfPTable(modelo.getColumnCount());

                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    tabela.addCell(modelo.getColumnName(i) + " ");
                }

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    for (int j = 0; j < modelo.getColumnCount(); j++) {
                        tabela.addCell(modelo.getValueAt(i, j).toString());
                    }
                }

                documento.add(tabela);

                documento.close();

                JOptionPane.showMessageDialog(null, "Relatório criado com sucesso! ");
                nomeLoja.setText(null);
                dispose();

            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione primeiro uma loja para então gerar um relatório!");
        }
    }//GEN-LAST:event_gerarRelatorioLojaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarLoja;
    private javax.swing.JButton buscarUsuario;
    private javax.swing.JButton gerarRelatorioLoja;
    private javax.swing.JButton gerarRelatorioUsuario;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeLoja;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JTable tabelaLoja;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables
}
