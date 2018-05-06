package br.com.atendemeupet.entidades;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
	@NamedQuery(query = "select s from Servico s", 
	name = "ListarTodosOsServicos"),
	@NamedQuery(query = "select distinct s from Servico s left join fetch"
			+ " s.lojas l where s.tipo like :pTipo", 
	name = "ListarServicoTipo"),
	@NamedQuery(query = "select distinct s from Servico s left join fetch"
			+ " s.lojas l where s.id = :pId",
	name = "ListarServicoId"),
	@NamedQuery(query = "select distinct s from Servico s left join fetch"
			+ " s.lojas l", 
	name = "ListarTodosOsServicosLojas"),
	@NamedQuery(query = "select distinct s from Servico s join fetch"
			+ " s.reservas r ", name = "ListarServicosReservas"),
	@NamedQuery(query = "select distinct s from Servico s join fetch"
			+ " s.reservas r join fetch r.loja l join fetch r.pet "
			+ "where s.tipo = :pTipo", name = "ListarTipoServicoReservas")
})
public class Servico {

	public Servico() {
	}

	public Servico(String tipo) {
		super();
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipo;

	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "servicos")
	private List<Reserva> reservas;
	
	@ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY, mappedBy = "servicos")
	private List<Loja> lojas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public String toString() {
		return "ID(" + id + ") Serviço: " + tipo;
	}

}
