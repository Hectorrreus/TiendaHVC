package com.nunegal.tfctienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nunegal.tfctienda.modelos.Vendedor;
import com.nunegal.tfctienda.repositorios.VendedorRepository;

@Service
public class VendedorServicio {

	@Autowired
	VendedorRepository repositorio;
	
	//@Autowired
	//BCryptPasswordEncoder passwordEncoder;
	
	public Vendedor registrar(Vendedor v) {
		//v.setContraseña(passwordEncoder.encode(v.getContraseña()));
		return repositorio.save(v);
	}
	
	public Vendedor buscarDni(String dni) {
		return repositorio.findByDni_Vendedor(dni);
	}
	
	public Vendedor buscarCorreo(String correo) {
		return repositorio.findByCorreo(correo);
	}
}
