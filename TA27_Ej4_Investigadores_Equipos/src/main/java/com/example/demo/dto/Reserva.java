package com.example.demo.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reservas")
public class Reserva {

	@Id
    @JoinColumn(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "comienzo")
    private Date comienzo;

	@Column(name = "fin")
    private Date fin;
	
	//@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "num_equipo")
    //@JsonIgnoreProperties("reservas")
	private Equipo equipo;
 
    @ManyToOne
    @JoinColumn(name = "dni_investigador")
    private Investigador investigador;
    

    public Reserva() {
    	
    }

	public Reserva(Integer id, Date comienzo, Date fin, Equipo equipo, Investigador investigador) {
		super();
		this.id = id;
		this.comienzo = comienzo;
		this.fin = fin;
		this.equipo = equipo;
		this.investigador = investigador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", equipo=" + equipo
				+ ", investigador=" + investigador + "]";
	}
}
