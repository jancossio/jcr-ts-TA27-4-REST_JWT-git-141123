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
@Table(name="equipos")
public class Equipo {

	@Id
	@Column(name = "num_serie")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	
    @ManyToOne
    @JoinColumn(name = "cod_facultad")
    private Facultad facultad;
	
    @JsonIgnoreProperties("equipos")
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<Reserva> reservas;
	
	
	public Equipo() {
		
	}

	public Equipo(String id, String nombre, Facultad facultad, List<Reserva> reservas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Equipo [num_serie=" + id + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
}
