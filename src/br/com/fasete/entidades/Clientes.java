package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@NamedQuery(name="Clientes.findAll", query="SELECT c FROM Clientes c")
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codcliente;

	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date datacadastro;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Pedidos
	@OneToMany(mappedBy="cliente")
	private List<Pedidos> pedidos;

	public Clientes() {
	}

	public Integer getCodcliente() {
		return this.codcliente;
	}

	public void setCodcliente(Integer codcliente) {
		this.codcliente = codcliente;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedidos> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedidos addPedido(Pedidos pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedidos removePedido(Pedidos pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

}