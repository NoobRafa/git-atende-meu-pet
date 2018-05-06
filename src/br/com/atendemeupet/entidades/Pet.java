package br.com.atendemeupet.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
		@NamedQuery(query = "select p from Pet p left join fetch p.usuario u order by p.id asc",
		name = "ListarTodosOsPets"),
		@NamedQuery(query = "select p from Pet p where p.usuario = :pUsuario",
		name = "ListarTodosOsPetsDoUsuario"),
		@NamedQuery(query = "select p from Pet p where p.nome = :pNome",
		name = "ListarPetNome") })
public class Pet  {
	public Pet() {
		super();
	}

	public Pet(String nome, String genero, int idade) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String genero;
	private int idade;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String toString() {
//		if (this.usuario == null) {
			return "Pet" + "(" + id + "):\nNome:" + nome + "\nGênero: "
					+ genero + "\nIdade: " + idade;
//		}
//		return "Pet" + "(" + id + "):\nNome:" + nome + "\nGênero: "
//		+ genero + "\nIdade: " + idade + "\n" + usuario;

	}

}
