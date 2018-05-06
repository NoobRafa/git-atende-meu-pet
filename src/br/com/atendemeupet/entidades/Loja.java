package br.com.atendemeupet.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(query = "select l from Loja l", name = "ListarTodasAsLojas"),
	@NamedQuery(query = "select l from Loja l left join fetch"
			+ " l.servicos s where l.razaoSocial like :pNome", 
	name = "ListarLojaNome"),
	@NamedQuery(query = "select l from Loja l where l.usuario like :pUsuario", 
	name = "ListarLojaUsuario"),
	@NamedQuery(query = "select l from Loja l where l.id = :pId",
	name = "ListarLojaId"),
	@NamedQuery(query = "select l from Loja l left join fetch l.servicos s",
	name = "ListarLojasServicos"),
	@NamedQuery(query = "select l from Loja l left join fetch l.usuario u order by l.id asc", 
	name = "ListarLojasUsuario"),
	@NamedQuery(query = "select l from Loja l join fetch l.reservas r "
			+ "join fetch r.usuario u join fetch r.pet p  "
			+ "where l.id = :pId", name = "ListarLojaIdReservas"),
	@NamedQuery(query = "select distinct l from Loja l join fetch l.reservas r "
			+ "join fetch r.usuario u join fetch r.pet p "
			+ " where l.razaoSocial =:pNome", name = "ListarLojaNomeReservas"),
	@NamedQuery(query = "select distinct l from Loja l "
			+ "join fetch l.reservas r ",name = "ListarLojasReservas")
	
})
public class Loja {
	public Loja(String razaoSocial, Usuario usuario) {
		super();
		this.razaoSocial = razaoSocial;
		this.usuario = usuario;
	}
	
	public Loja(String razaoSocial, Usuario usuario, List<Servico> servicos) {
		super();
		this.razaoSocial = razaoSocial;
		this.usuario = usuario;
		this.servicos = servicos;
	}

	public Loja() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String razaoSocial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,mappedBy = "loja")
	private List<Reserva> reservas;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Servico> servicos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Loja [id=" + id + ", razaoSocial=" + razaoSocial + "]";
	}

}
