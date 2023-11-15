package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {

	public List<Reserva> listarReservas(); 

	public Reserva guardarReserva(Reserva reserva);	

	public Reserva obtenerReserva(Integer id); 

	public Reserva actualizarReserva(Reserva reserva); 

	public void eliminarReserva(Integer id);
}
