package com.joses.demo.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joses.demo.interfaceService.IpersonaService;
import com.joses.demo.interfaces.IPersona;
import com.joses.demo.modelo.Persona;

@Service
public class PersonaService implements IpersonaService{

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>)data.findAll();
	}
	
	//editar
	@Override
	public Optional<Persona> listarId(int id) {

		return data.findById(id);
	}
	
	//guardar
	@Override
	public int save(Persona p) {
		int respuesta=0;
		Persona persona = data.save(p);
		if(!persona.equals(null)) {
			respuesta= 1;
		}
		return respuesta;
	}

	//borrar
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
