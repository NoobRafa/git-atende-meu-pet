package br.com.atendemeupet.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")
@ToString(of = {"id", "nome", "cpf", "endereco", "email", "telefone"})
@NamedQueries({
    @NamedQuery(query = "select user from Usuario user", name = "ListarTodosOsUsuarios"),
    @NamedQuery(query = "select usr from Usuario usr where usr.nome like :pNome", name = "ListarUsuarioNome"),
    @NamedQuery(query = "select usr from Usuario usr where usr.id = :pId", name = "ListarUsuarioId"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.pets p", name = "ListarUsuariosPets"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.pets p where usr.id = :pId", name = "ListarUsuarioIdPets"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.pets p where usr.nome = :pNome", name = "ListarUsuarioNomePets"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.reservas r", name = "ListarTodosUsuariosReservas"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.reservas r where usr.id = :pId", name = "ListarUsuarioIdReservas"),
    @NamedQuery(query = "select distinct usr from Usuario usr join fetch usr.reservas r where usr.nome = :pNome", name = "ListarUsuarioNomeReservas")
    
})
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String email;
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Pet> pets;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "usuario")
    private List<Reserva> reservas;
    

    public Usuario(String nome, String cpf, Endereco endereco, String email,
            String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

}
