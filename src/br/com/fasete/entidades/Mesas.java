package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesas database table.
 * 
 */
@Entity
@NamedQuery(name="Mesas.findAll", query="SELECT m FROM Mesas m")
public class Mesas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codmesa;

	private Integer numero;

	private Integer qtdcadeiras;

	//bi-directional many-to-one association to Pedidos
	@OneToMany(mappedBy="mesa")
	private List<Pedidos> pedidos;

	//bi-directional many-to-one association to Reservas
	@OneToMany(mappedBy="mesa")
	private List<Reservas> reservas;

	public Mesas() {
	}

	public Integer getCodmesa() {
		return this.codmesa;
	}

	public void setCodmesa(Integer codmesa) {
		this.codmesa = codmesa;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getQtdcadeiras() {
		return this.qtdcadeiras;
	}

	public void setQtdcadeiras(Integer qtdcadeiras) {
		this.qtdcadeiras = qtdcadeiras;
	}

	public List<Pedidos> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedidos addPedido(Pedidos pedido) {
		getPedidos().add(pedido);
		pedido.setMesa(this);

		return pedido;
	}

	public Pedidos removePedido(Pedidos pedido) {
		getPedidos().remove(pedido);
		pedido.setMesa(null);

		return pedido;
	}

	public List<Reservas> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}

	public Reservas addReserva(Reservas reserva) {
		getReservas().add(reserva);
		reserva.setMesa(this);

		return reserva;
	}

	public Reservas removeReserva(Reservas reserva) {
		getReservas().remove(reserva);
		reserva.setMesa(null);

		return reserva;
	}

}