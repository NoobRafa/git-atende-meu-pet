package br.com.atendemeupet.entidades;

import java.text.SimpleDateFormat;
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



@Entity
@NamedQueries({
	@NamedQuery(query = "select r from Reserva r", name = "ListarTodasAsReservas"),
	@NamedQuery(query= "select distinct r from Reserva r  left join fetch r.loja l "
			+ "left join fetch r.usuario u left join fetch r.pet p left join fetch r.servicos s "
			+ "where r.id = :pId", name = "ListarReservaId"),
	@NamedQuery(query= "select r from Reserva r join fetch r.loja l "
			+ "join fetch r.usuario u join fetch r.pet p join fetch r.servicos s "
			+ "where r.loja = :pLoja", name = "ListarReservasLoja"),
	@NamedQuery(query= "select r from Reserva r join fetch r.loja l "
			+ "join fetch r.usuario u join fetch r.pet p join fetch r.servicos s "
			+ "where r.usuario = :pUsuario", name = "ListarReservasUsuario"),
	
})
public class Reserva {
	public Reserva(Calendar horario) {
		super();
		this.horario = horario;
	}
	
	public Reserva() {
		super();
	}

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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "reservas_servicos")
	private List<Servico> servicos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String hora = formato.format(horario.getTime()); 
		return "Reserva [id=" + id + ", horario=" + hora + "]";
	}
	
	
}
