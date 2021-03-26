package com.nunegal.tfctienda.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.nunegal.tfctienda.modelos.Cliente;
import com.nunegal.tfctienda.repositorios.ClienteRepository;
import com.nunegal.tfctienda.repositorios.VendedorRepository;

@RequestMapping("/cliente")
@RestController
public class LoginController {
	
	@Autowired
	ClienteRepository clienteRepository;
//	
//	@Autowired	
//	VendedorRepository vendedorRepository;
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello, world";
	}
	
	@PostMapping("/registrarcliente")
	public void registroCliente(@ModelAttribute Cliente cliente) {		
		clienteRepository.save(cliente);
	}
	
	@RequestMapping(value="{dni_cliente}")
	public ResponseEntity<Cliente> gerClienteByDni(@PathVariable("dni_cliente") String dni_cliente){
		Optional<Cliente> optionalCliente = Optional.of(clienteRepository.findByDni_cliente(dni_cliente));
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}

}
