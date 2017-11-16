package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produtos database table.
 * 
 */
@Entity
@NamedQuery(name="Produtos.findAll", query="SELECT p FROM Produtos p")
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codproduto;

	private String descricao;

	private double valor;

	//bi-directional many-to-one association to Itempedidos
	@OneToMany(mappedBy="produto")
	private List<Itempedidos> itempedidos;

	//bi-directional many-to-one association to Tipoproduto
	@ManyToOne
	@JoinColumn(name="codtipoproduto")
	private Tipoproduto tipoproduto;

	public Produtos() {
	}

	public Integer getCodproduto() {
		return this.codproduto;
	}

	public void setCodproduto(Integer codproduto) {
		this.codproduto = codproduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Itempedidos> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedidos> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedidos addItempedido(Itempedidos itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setProduto(this);

		return itempedido;
	}

	public Itempedidos removeItempedido(Itempedidos itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setProduto(null);

		return itempedido;
	}

	public Tipoproduto getTipoproduto() {
		return this.tipoproduto;
	}

	public void setTipoproduto(Tipoproduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

}