/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.modelos;

import br.com.atendemeupet.entidades.Pet;
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
public class PetTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<Pet> dados;

    private final String[] colunas = {"ID", "Nome", "Idade", "Gênero"};

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
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getIdade();
            case 3:
                return dados.get(rowIndex).getGenero();

        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setIdade((int) aValue);
                break;
            case 3:
                dados.get(rowIndex).setGenero((String) aValue);
                break;
        }

        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Pet removeRow(int rowIndex) {
        Pet usuario = this.dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return usuario;

    }

    public Pet getRow(int rowIndex) {
        Pet usuario = dados.get(rowIndex);
        return usuario;
    }

}
