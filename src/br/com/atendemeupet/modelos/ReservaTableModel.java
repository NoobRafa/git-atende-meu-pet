/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atendemeupet.modelos;

import br.com.atendemeupet.entidades.Reserva;
import br.com.atendemeupet.entidades.Servico;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class ReservaTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<Reserva> dados;

    private final String[] colunas = {"ID_Reserva", "Usuário", "Pet", "Loja", "Serviços", "Horário"};

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
                return dados.get(rowIndex).getUsuario().getNome();
            case 2:
                return dados.get(rowIndex).getPet().getNome();
            case 3:
                return dados.get(rowIndex).getLoja().getRazaoSocial();
            case 4:
                String str = "";

                for (Servico servico : dados.get(rowIndex).getServicos()) {
                    str += servico.getTipo() + " ";
                }

                return str;
            case 5:
                Calendar horario = dados.get(rowIndex).getHorario();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String hora = formato.format(horario.getTime());
                return hora;
        }

        return null;
    }

    public Reserva removeRow(int rowIndex) {
        Reserva reserva = this.dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return reserva;

    }

    public Reserva getRow(int rowIndex) {
        Reserva reserva = dados.get(rowIndex);
        return reserva;
    }

}
