package com.nunegal.tfctienda.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Carrito;
import com.nunegal.tfctienda.modelos.Linea_carrito;
import com.nunegal.tfctienda.repositorios.CarritoRepository;
import com.nunegal.tfctienda.repositorios.LineaCarritoRepository;



@RequestMapping("/carrito")
@RestController
public class CarritoController {
	
	@Autowired
	CarritoRepository carritoRepository;
	@Autowired
	LineaCarritoRepository lineaCarritoRepository;
		
	@RequestMapping(value="/dni_usuario/{dni_usuario}")
	public ResponseEntity<Carrito> getcarritoByDni (@PathVariable("dni_usuario") String dni_usuario) {
		Optional<Carrito> optionalcarrito = Optional.of(carritoRepository.findByDni_usuario(dni_usuario));
		if(optionalcarrito.isPresent()) {
			return ResponseEntity.ok(optionalcarrito.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/id/{id_carrito}")
	public ResponseEntity<Carrito> getcarritoById (@PathVariable("id_carrito") int id_carrito) {
		Optional<Carrito> optionalcarrito = carritoRepository.findById(id_carrito);
		if(optionalcarrito.isPresent()) {
			return ResponseEntity.ok(optionalcarrito.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/registrarlineas")
	public ResponseEntity<Linea_carrito> crearLineaCarrito (@RequestBody Linea_carrito lineascarrito) {
		int id = lineaCarritoRepository.findMaxIdLinea();
		lineascarrito.setId_lineacarrito(id);
		System.out.println (lineascarrito.toString());
		Linea_carrito linea = lineaCarritoRepository.save(lineascarrito);
		return ResponseEntity.ok(linea);
	}
	
	@DeleteMapping("/borrarlineas/{id_lineacarrito}")
	public ResponseEntity<Linea_carrito> borrarLineaCarrito (@PathVariable("id_lineacarrito") int id_lineacarrito) {
		lineaCarritoRepository.deleteById(id_lineacarrito);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(value="/lineas/{id_carrito}")
	public ResponseEntity<List<Linea_carrito>> getLineasCarritoById (@PathVariable("id_carrito") int id_carrito) {
		List<Linea_carrito> lineas = lineaCarritoRepository.findById_carrito(id_carrito);
		if(lineas.size()>0) {
			return ResponseEntity.ok(lineas);
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
		

}
