package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {

	public List<Investigador> listarInvestigadores(); 

	public Investigador guardarInvestigador(Investigador investigador);	

	public Investigador obtenerInvestigador(String id); 

	public Investigador actualizarInvestigador(Investigador investigador); 

	public void eliminarInvestigador(String id);
}
