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

import com.nunegal.tfctienda.modelos.Vendedor;
import com.nunegal.tfctienda.repositorios.VendedorRepository;

@RequestMapping("/vendedor")
@RestController
public class VendedorController {

	@Autowired
	VendedorRepository vendedorRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Vendedor> crearVendedor(@RequestBody Vendedor Vendedor) {		
		Vendedor newvendedor = vendedorRepository.save(Vendedor);
		return ResponseEntity.ok(newvendedor);
	}
	
	@RequestMapping(value="/dni/{dni_vendedor}")
	public ResponseEntity<Vendedor> getVendedorByDni(@PathVariable("dni_vendedor") String dni_vendedor){
		Optional<Vendedor> optionalVendedor = vendedorRepository.findById(dni_vendedor);
		if(optionalVendedor.isPresent()) {
			return ResponseEntity.ok(optionalVendedor.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@RequestMapping(value="/correo/{correo}")
	public ResponseEntity<Vendedor> getVendedorByCorreo(@PathVariable("correo") String correo){
		Optional<Vendedor> optionalVendedor = Optional.of(vendedorRepository.findByCorreo(correo));
		if(optionalVendedor.isPresent()) {
			return ResponseEntity.ok(optionalVendedor.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@DeleteMapping("/borrar/{dni_vendedor}")
	public ResponseEntity<Void> borrarVendedor(@PathVariable("dni_vendedor") String dni_vendedor ) {
		vendedorRepository.deleteById(dni_vendedor);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Vendedor> actualizarVendedor(@RequestBody Vendedor vendedor) {
		Optional<Vendedor> optionalVendedor = vendedorRepository.findById(vendedor.getDni_vendedor());
		if(optionalVendedor.isPresent()) {
			Vendedor vendedorActualizado = optionalVendedor.get();
			vendedorActualizado.setNombre(vendedor.getNombre());
			vendedorActualizado.setApellidos(vendedor.getApellidos());
			vendedorActualizado.setFecha_nacimiento(vendedor.getFecha_nacimiento());
			vendedorActualizado.setBeneficio(vendedor.getBeneficio());
			vendedorRepository.save(vendedorActualizado);
			return ResponseEntity.ok(vendedorActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
