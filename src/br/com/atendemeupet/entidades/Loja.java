package br.com.atendemeupet.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"servicos", "reservas"})
@EqualsAndHashCode(of = "cnpj")
@NamedQueries({
    @NamedQuery(query = "select l from Loja l", name = "ListarTodasAsLojas"),
    @NamedQuery(query = "select l from Loja l where l.id = :pId", name = "ListarLojaId"),
    @NamedQuery(query = "select l from Loja l where l.razaoSocial = :pRazaoSocial", name = "ListarLojaRazaoSocial"),
    @NamedQuery(query = "select distinct l from Loja l join fetch l.reservas ", name = "ListarLojasReservas"),
    @NamedQuery(query = "select distinct l from Loja l join fetch l.servicos ", name = "ListarLojasServicos"),
    @NamedQuery(query = "select distinct l from Loja l join fetch l.servicos s where s.tipo = :pTipo", name = "ListarLojaPeloServico")
    
})
@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String razaoSocial;
    private String cnpj;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "loja")
    private List<Reserva> reservas;

    
    @ManyToMany(mappedBy = "lojas")
    private List<Servico> servicos;

    public Loja(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Loja(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    
}
