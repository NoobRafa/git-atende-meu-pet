/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.modelos;

import br.com.atendemeupet.entidades.Loja;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rafael Vieira
 */
@AllArgsConstructor
@NoArgsConstructor
public class LojaTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<Loja> dados;

    private final String[] colunas = {"ID", "Razão Social", "CNPJ"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dados.get(rowIndex).getId();
            case 1:
                return dados.get(rowIndex).getRazaoSocial();
            case 2:
                return dados.get(rowIndex).getCnpj();

        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                dados.get(rowIndex).setRazaoSocial((String) aValue);
                break;

        }

        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Loja removeRow(int rowIndex) {
        Loja usuario = this.dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return usuario;

    }

    public Loja getRow(int rowIndex) {
        Loja usuario = dados.get(rowIndex);
        return usuario;
    }

}
