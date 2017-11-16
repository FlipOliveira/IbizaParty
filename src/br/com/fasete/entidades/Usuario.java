package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codusuario;

	private String login;

	private String senha;

	public Usuario() {
	}

	public Integer getCodusuario() {
		return this.codusuario;
	}

	public void setCodusuario(Integer codusuario) {
		this.codusuario = codusuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}