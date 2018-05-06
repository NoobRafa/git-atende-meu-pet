package br.com.atendemeupet.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


//createNamedQuery() -- Coloca o nome da query nomeada na entidade.
@Entity
@NamedQueries({
		@NamedQuery(query = "select usr from Usuario usr", 
	    name = "ListarTodosOsUsuarios"),
		@NamedQuery(query = "select usr from Usuario usr where usr.nome like :pNome", 
		name = "ListarUsuarioNome"),
		@NamedQuery(query = "select usr from Usuario usr where usr.id = :pId",
		name = "ListarUsuarioId"),
		@NamedQuery(query = "select distinct usr from Usuario usr left join fetch usr.pets p order by usr.id asc", 
		name = "ListarUsuarioPets"),
		@NamedQuery(query = "select distinct usr from Usuario usr left join fetch usr.lojas l order by usr.id asc", 
		name = "ListarUsuariosLojas"),
		@NamedQuery(query = "select distinct usr from Usuario usr left join fetch usr.lojas l "
				+ "where usr.nome like :pNome", 
		name = "ListarUsuarioLojas"),
		@NamedQuery(query = "select usr from Usuario usr join fetch usr.reservas r",
		name = "ListarTodosUsuariosReservas"),
		@NamedQuery(query = "select usr from Usuario usr join fetch usr.reservas r "
				+ "join fetch r.loja l join fetch r.pet p where usr.id =:pId",
		name = "ListarUsuarioIdReservas"),
		@NamedQuery(query = "select usr from Usuario usr join fetch usr.reservas r "
				+ "join fetch r.loja l join fetch r.pet p where usr.nome =:pNome",
		name = "ListarUsuarioNomeReservas")
})
public class Usuario {

	public Usuario(String nome, String cpf, String end, String email,
			String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.end = end;
		this.email = email;
		this.telefone = telefone;	
	}

	public Usuario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpf;

	private String end;

	private String email;
	private String telefone;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY,mappedBy = "usuario")
	private List<Pet> pets;

	@OneToMany(cascade = CascadeType.REMOVE,fetch= FetchType.LAZY,mappedBy = "usuario")
	private List<Reserva> reservas;
	
	@OneToMany(cascade = CascadeType.REMOVE,fetch= FetchType.LAZY,mappedBy = "usuario")
	private List<Loja> lojas;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public void setLojas(List<Loja> lojas){
		this.lojas = lojas;
	}
	
	public List<Loja> getLojas(){
		return lojas;
	}
	public String toString() {
		return "Usr " + "(" + id + "):\nNome: " + nome + "\nCPF: " + cpf + "\n"
				+ "End: " + end + "\n" + "Fone: " + telefone + "\n" + "Email: "
				+ email;
	}

}
