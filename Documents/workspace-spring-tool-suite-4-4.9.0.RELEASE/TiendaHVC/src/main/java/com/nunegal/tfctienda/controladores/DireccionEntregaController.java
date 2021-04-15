package com.nunegal.tfctienda.controladores;

import java.util.List;
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

import com.nunegal.tfctienda.modelos.Direccion_entrega;
import com.nunegal.tfctienda.modelos.Producto;
import com.nunegal.tfctienda.repositorios.DireccionEntregaRepository;

@RequestMapping("/direccionentrega")
@RestController
public class DireccionEntregaController {
	
	@Autowired
	DireccionEntregaRepository direccionRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Direccion_entrega> crearDireccion (@RequestBody Direccion_entrega direccion) {
		Direccion_entrega newdireccion = direccionRepository.save(direccion);
		return ResponseEntity.ok(newdireccion);
	}
	
	@RequestMapping(value="/id/{id_direccion}")
	public ResponseEntity<Direccion_entrega> getDireccionById (@PathVariable("id_direccion") int id_direccion) {
		Optional<Direccion_entrega> optionalDireccion= direccionRepository.findById(id_direccion);
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/dni_usuario/{dni_usuario}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByDni (@PathVariable("dni_usuario") String dni_usuario) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByDni_Usuario(dni_usuario));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/pais/{pais}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByPais (@PathVariable("pais") String pais) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByPais(pais));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/provincia/{provincia}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByProvincia (@PathVariable("provincia") String provincia) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByPais(provincia));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/ciudad/{ciudad}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByCiudad (@PathVariable("ciudad") String ciudad) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByPais(ciudad));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/codigopostal/{codigopostal}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByCodigoPostal (@PathVariable("codigopostal") String codigopostal) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByPais(codigopostal));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/calle/{calle}")
	public ResponseEntity<List<Direccion_entrega>> getDireccionByCalle (@PathVariable("calle") String calle) {
		Optional<List<Direccion_entrega>> optionalDireccion = Optional.of(direccionRepository.findByPais(calle));
		if(optionalDireccion.isPresent()) {
			return ResponseEntity.ok(optionalDireccion.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/borrar/{id_direccion}")
	public ResponseEntity<Void> borrarDireccion(@PathVariable("id_direccion") int id_direccion) {
		direccionRepository.deleteById(id_direccion);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Direccion_entrega> actualizarDireccion(@RequestBody Direccion_entrega direccion) {
		Optional<Direccion_entrega> optionalDireccion = direccionRepository.findById(direccion.getId_direccionesentrega());
		if(optionalDireccion.isPresent()) {
			Direccion_entrega direccionActualizada = optionalDireccion.get();
			direccionActualizada.setPais(direccion.getPais());
			direccionActualizada.setProvincia(direccion.getProvincia());
			direccionActualizada.setCiudad(direccion.getCiudad());
			direccionActualizada.setCodigopostal(direccion.getCodigopostal());
			direccionActualizada.setCalle(direccion.getCalle());
			direccionActualizada.setNumero(direccion.getNumero());	
			direccionRepository.save(direccionActualizada);
			return ResponseEntity.ok(direccionActualizada);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}


}
