package br.com.atendemeupet.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(of = "tipo")
@NoArgsConstructor
@ToString(exclude = {"reservas", "lojas"})
@NamedQueries({
    @NamedQuery(query = "select s from Servico s", name = "ListarTodosServicos"),
    @NamedQuery(query = "select s from Servico s where s.tipo = :pTipo", name = "ListarServicosTipo"),
    @NamedQuery(query = "select s from Servico s where s.id = :pId", name = "ListarServicosId"),
    @NamedQuery(query = "select distinct s from Servico s join fetch s.lojas l where l = :pLoja", name = "ListarServicosLoja"),
    @NamedQuery(query = "select distinct s from Servico s join fetch s.lojas", name = "ListarServicosLojaGeral"),
    @NamedQuery(query = "select distinct s from Servico s join fetch s.reservas r where r = :pReserva", name = "ListarServicosReserva"),
})
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "servicos")
    private List<Reserva> reservas;

    @JoinTable(name = "servicos_lojas")
    @ManyToMany
    private List<Loja> lojas;
    
     public Servico(String tipo) {
        this.tipo = tipo;
    }
}
