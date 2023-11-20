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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/all")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	
	
	@PostMapping("/add")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	
	@GetMapping("/{id}")
	public Reserva obtenerReserva(@PathVariable(name="id") Integer id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=reservaServiceImpl.obtenerReserva(id);
		
		return Reserva_xid;
	}
	
	@PutMapping("/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")Integer id,@RequestBody Reserva reserva) {
		
		Reserva Reserva_seleccionada= new Reserva();
		Reserva Reserva_actualizada= new Reserva();
		
		Reserva_seleccionada= reservaServiceImpl.obtenerReserva(id);
		
		Reserva_seleccionada.setEquipo(reserva.getEquipo());
		Reserva_seleccionada.setInvestigador(reserva.getInvestigador());
		Reserva_seleccionada.setComienzo(reserva.getComienzo());
		Reserva_seleccionada.setFin(reserva.getFin());
		
		Reserva_actualizada = reservaServiceImpl.actualizarReserva(Reserva_seleccionada);
				
		return Reserva_actualizada;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarReserva(@PathVariable(name="id")Integer id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
