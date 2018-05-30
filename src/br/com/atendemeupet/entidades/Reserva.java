package br.com.atendemeupet.entidades;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(query = "select r from Reserva r", name = "ListarTodasAsReservas"),
    @NamedQuery(query = "select r from Reserva r where r.id = :pId", name = "ListarReservaId"),
    @NamedQuery(query = "select r from Reserva r where r.loja = :pLoja", name = "ListarReservasLoja"),
    @NamedQuery(query = "select distinct r from Reserva r where r.usuario = :pUsuario", name = "ListarReservasUsuario"),
})
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horario;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    @ManyToMany
    @JoinTable(name = "reservas_servicos")
    private List<Servico> servicos;

    public Reserva(Calendar horario) {
        this.horario = horario;
    }
    
    

}
