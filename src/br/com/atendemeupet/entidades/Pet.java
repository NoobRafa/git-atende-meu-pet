package br.com.atendemeupet.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString(exclude = "usuario")
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(query = "select p from Pet p", name = "ListarTodosOsPets"),
    @NamedQuery(query = "select distinct p from Pet p where p.usuario = :pUsuario", name = "ListarTodosOsPetsDoUsuario"),
    @NamedQuery(query = "select p from Pet p where p.nome = :pNome", name = "ListarPetNome")
})
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String genero;
    private int idade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Pet(String nome, String genero, int idade) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }
    
    


}
