package com.nunegal.tfctienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nunegal.tfctienda.modelos.Cliente;
import com.nunegal.tfctienda.repositorios.ClienteRepository;

@Service
public class ClienteServicio {
	
	@Autowired
	ClienteRepository repositorio;
	
	
	//@Autowired
	//BCryptPasswordEncoder passwordEncoder;
	
	public Cliente registrar (Cliente c) {
		//c.setContraseña(passwordEncoder.encode(c.getContraseña()));
		return repositorio.save(c);
	}
	
	public Cliente buscarDni (String dni) {
		return repositorio.findByDni_cliente(dni);
	}
	
	public Cliente buscarCorreo (String correo) {
		return repositorio.findByCorreo(correo);
	}
}
