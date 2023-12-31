package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {

	public List<Facultad> listarFacultades(); 

	public Facultad guardarFacultad(Facultad facultad);	

	public Facultad obtenerFacultad(Integer id); 

	public Facultad actualizarFacultad(Facultad facultad); 

	public void eliminarFacultad(Integer id);
}
