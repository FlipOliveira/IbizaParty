package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itempedidos database table.
 * 
 */
@Entity
@NamedQuery(name="Itempedidos.findAll", query="SELECT i FROM Itempedidos i")
public class Itempedidos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer coditempedido;

	private String descricao;

	private Integer quantidade;

	private double valoritem;

	//bi-directional many-to-one association to Pedidos
	@ManyToOne
	@JoinColumn(name="codpedido")
	private Pedidos pedido;

	//bi-directional many-to-one association to Produtos
	@ManyToOne
	@JoinColumn(name="codproduto")
	private Produtos produto;

	public Itempedidos() {
	}

	public Integer getCoditempedido() {
		return this.coditempedido;
	}

	public void setCoditempedido(Integer coditempedido) {
		this.coditempedido = coditempedido;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValoritem() {
		return this.valoritem;
	}

	public void setValoritem(double valoritem) {
		this.valoritem = valoritem;
	}

	public Pedidos getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Produtos getProduto() {
		return this.produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

}