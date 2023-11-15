package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/facultad")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/all")
	public List<Facultad> listarFacultades(){
		return facultadServiceImpl.listarFacultades();
	}
	
	
	@PostMapping("/add")
	public Facultad guardarFacultad(@RequestBody Facultad equipo) {
		
		return facultadServiceImpl.guardarFacultad(equipo);
	}
	
	
	@GetMapping("/{codigo}")
	public Facultad obtenerFacultad(@PathVariable(name="codigo") Integer id) {
		
		Facultad Equipo_xid= new Facultad();
		
		Equipo_xid=facultadServiceImpl.obtenerFacultad(id);
		
		return Equipo_xid;
	}
	
	@PutMapping("/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")Integer id,@RequestBody Facultad facultad) {
		
		Facultad Facultad_seleccionada= new Facultad();
		Facultad Facultad_actualizada= new Facultad();
		
		Facultad_seleccionada= facultadServiceImpl.obtenerFacultad(id);
		
		Facultad_seleccionada.setNombre(facultad.getNombre());
		
		Facultad_actualizada = facultadServiceImpl.actualizarFacultad(Facultad_seleccionada);
				
		return Facultad_actualizada;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarFacultad(@PathVariable(name="codigo")Integer id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
}
