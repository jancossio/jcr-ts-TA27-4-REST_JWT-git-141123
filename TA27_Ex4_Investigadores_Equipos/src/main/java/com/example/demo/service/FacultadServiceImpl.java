package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{

	@Autowired
	IFacultadDAO iFacultadDAO;
	
	@Override
	public List<Facultad> listarFacultades(){
		return iFacultadDAO.findAll();
	}
	
	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}
	
	@Override
	public Facultad obtenerFacultad(Integer id) {
		return iFacultadDAO.findById(id).get();
	}
	
	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}
	
	@Override
	public void eliminarFacultad(Integer id) {
		iFacultadDAO.deleteById(id);
	}
}
