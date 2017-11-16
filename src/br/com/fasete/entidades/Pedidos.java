package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@NamedQuery(name="Pedidos.findAll", query="SELECT p FROM Pedidos p")
public class Pedidos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codpedido;

	@Temporal(TemporalType.DATE)
	private Date datapedido;

	private Integer numero;

	private double total;

	//bi-directional many-to-one association to Itempedidos
	@OneToMany(mappedBy="pedido")
	private List<Itempedidos> itempedidos;

	//bi-directional many-to-one association to Clientes
	@ManyToOne
	@JoinColumn(name="codcliente")
	private Clientes cliente;

	//bi-directional many-to-one association to Mesas
	@ManyToOne
	@JoinColumn(name="codmesa")
	private Mesas mesa;

	public Pedidos() {
	}

	public Integer getCodpedido() {
		return this.codpedido;
	}

	public void setCodpedido(Integer codpedido) {
		this.codpedido = codpedido;
	}

	public Date getDatapedido() {
		return this.datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Itempedidos> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedidos> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedidos addItempedido(Itempedidos itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setPedido(this);

		return itempedido;
	}

	public Itempedidos removeItempedido(Itempedidos itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setPedido(null);

		return itempedido;
	}

	public Clientes getCliente() {
		return this.cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Mesas getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesas mesa) {
		this.mesa = mesa;
	}

}