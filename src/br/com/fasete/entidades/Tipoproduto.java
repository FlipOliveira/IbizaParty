package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoproduto database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoproduto.findAll", query="SELECT t FROM Tipoproduto t")
public class Tipoproduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codtipoproduto;

	private String tipo;

	//bi-directional many-to-one association to Produtos
	@OneToMany(mappedBy="tipoproduto")
	private List<Produtos> produtos;

	public Tipoproduto() {
	}

	public Integer getCodtipoproduto() {
		return this.codtipoproduto;
	}

	public void setCodtipoproduto(Integer codtipoproduto) {
		this.codtipoproduto = codtipoproduto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produtos> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public Produtos addProduto(Produtos produto) {
		getProdutos().add(produto);
		produto.setTipoproduto(this);

		return produto;
	}

	public Produtos removeProduto(Produtos produto) {
		getProdutos().remove(produto);
		produto.setTipoproduto(null);

		return produto;
	}

}