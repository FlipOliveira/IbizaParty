package br.com.fasete.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@NamedQuery(name="Reservas.findAll", query="SELECT r FROM Reservas r")
public class Reservas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codreserva;

	@Temporal(TemporalType.DATE)
	private Date datareserva;

	private Time horario;

	//bi-directional many-to-one association to Mesas
	@ManyToOne
	@JoinColumn(name="codmesa")
	private Mesas mesa;

	public Reservas() {
	}

	public Integer getCodreserva() {
		return this.codreserva;
	}

	public void setCodreserva(Integer codreserva) {
		this.codreserva = codreserva;
	}

	public Date getDatareserva() {
		return this.datareserva;
	}

	public void setDatareserva(Date datareserva) {
		this.datareserva = datareserva;
	}

	public Time getHorario() {
		return this.horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Mesas getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesas mesa) {
		this.mesa = mesa;
	}

}