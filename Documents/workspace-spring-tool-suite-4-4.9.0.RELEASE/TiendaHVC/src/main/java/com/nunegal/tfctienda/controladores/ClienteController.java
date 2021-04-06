package com.nunegal.tfctienda.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Cliente;
import com.nunegal.tfctienda.repositorios.ClienteRepository;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {		
		Cliente newcliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(newcliente);
	}
	
	@RequestMapping(value="/dni/{dni_cliente}")
	public ResponseEntity<Cliente> getClienteByDni(@PathVariable("dni_cliente") String dni_cliente){
		Optional<Cliente> optionalCliente = clienteRepository.findById(dni_cliente);
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@RequestMapping(value="/correo/{correo}")
	public ResponseEntity<Cliente> getClienteByCorreo(@PathVariable("correo") String correo){
		Optional<Cliente> optionalCliente = Optional.of(clienteRepository.findByCorreo(correo));
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@DeleteMapping("/borrar")
	public ResponseEntity<Void> borrarCliente(@PathVariable("dni_cliente") String dni_cliente ) {
		clienteRepository.deleteById(dni_cliente);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(cliente.getDni_cliente());
		if(optionalCliente.isPresent()) {
			Cliente clienteActualizado = optionalCliente.get();
			clienteActualizado.setNombre(cliente.getNombre());
			clienteActualizado.setApellidos(cliente.getApellidos());
			clienteActualizado.setFecha_nacimiento(cliente.getFecha_nacimiento());
			clienteRepository.save(clienteActualizado);
			return ResponseEntity.ok(clienteActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
