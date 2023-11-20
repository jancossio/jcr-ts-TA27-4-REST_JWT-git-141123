package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="investigadores")
public class Investigador {

	@Id
	@Column(name = "dni")
	private String id;
	@Column(name = "nom_apels")
	private String nomApels;
	
    @ManyToOne
    @JoinColumn(name = "cod_facultad")
    private Facultad facultad;
	
	@JsonIgnore
    @OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
	
	public Investigador() {
		
	}

	public Investigador(String id, String nomApels, Facultad facultad, List<Reserva> reservas) {
		super();
		this.id = id;
		this.nomApels = nomApels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + id + ", nomApels=" + nomApels + ", facultad=" + facultad + "]";
	}
}
