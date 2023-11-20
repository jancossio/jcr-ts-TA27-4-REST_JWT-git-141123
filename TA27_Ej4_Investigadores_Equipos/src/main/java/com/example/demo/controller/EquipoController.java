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

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/all")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/add")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/{num_serie}")
	public Equipo obtenerEquipo(@PathVariable(name="num_serie") String num_serie) {
		
		Equipo Equipo_xid= new Equipo();
		
		Equipo_xid=equipoServiceImpl.obtenerEquipo(num_serie);
		
		return Equipo_xid;
	}
	
	@PutMapping("/{num_serie}")
	public Equipo actualizarEquipo(@PathVariable(name="num_serie")String num_serie,@RequestBody Equipo equipo) {
		
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();
		
		Equipo_seleccionado= equipoServiceImpl.obtenerEquipo(num_serie);
		
		Equipo_seleccionado.setId(equipo.getId());
		Equipo_seleccionado.setNombre(equipo.getNombre());
		Equipo_seleccionado.setFacultad(equipo.getFacultad());
		
		Equipo_actualizado = equipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
				
		return Equipo_actualizado;
	}
	
	@DeleteMapping("/{num_serie}")
	public void eliminarEquipo(@PathVariable(name="num_serie")String num_serie) {
		equipoServiceImpl.eliminarEquipo(num_serie);
	}
}
