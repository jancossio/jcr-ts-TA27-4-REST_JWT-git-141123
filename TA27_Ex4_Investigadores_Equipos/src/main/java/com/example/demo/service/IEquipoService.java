package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoService {

	public List<Equipo> listarEquipos(); 

	public Equipo guardarEquipo(Equipo equipo);	

	public Equipo obtenerEquipo(String id); 

	public Equipo actualizarEquipo(Equipo equipo); 

	public void eliminarEquipo(String id);
}