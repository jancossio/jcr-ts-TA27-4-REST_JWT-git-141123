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

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/investigador")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/all")
	public List<Investigador> listarInvestigadores(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/add")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/{dni}")
	public Investigador obtenerInvestigador(@PathVariable(name="dni") String dni) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=investigadorServiceImpl.obtenerInvestigador(dni);
		
		return Investigador_xid;
	}
	
	@PutMapping("/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigador investigador) {
		
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();
		
		Investigador_seleccionado= investigadorServiceImpl.obtenerInvestigador(dni);
		
		Investigador_seleccionado.setId(investigador.getId());
		Investigador_seleccionado.setNomApels(investigador.getNomApels());
		Investigador_seleccionado.setFacultad(investigador.getFacultad());

		
		Investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
				
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/{dni}")
	public void eliminarInvestigador(@PathVariable(name="dni")String dni) {
		investigadorServiceImpl.eliminarInvestigador(dni);
	}
}
