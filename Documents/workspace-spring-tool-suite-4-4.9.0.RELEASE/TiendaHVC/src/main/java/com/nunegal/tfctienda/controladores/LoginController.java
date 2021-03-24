package com.nunegal.tfctienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nunegal.tfctienda.repositorios.ClienteRepository;
import com.nunegal.tfctienda.repositorios.VendedorRepository;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello, world";
	}
	

}
