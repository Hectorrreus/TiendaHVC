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

import com.nunegal.tfctienda.modelos.Producto;
import com.nunegal.tfctienda.repositorios.ProductoRepository;

@RequestMapping("/producto")
@RestController
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Producto> crearProducto (@RequestBody Producto producto) {
		Producto newproducto = productoRepository.save(producto);
		return ResponseEntity.ok(newproducto);
	}
	
	@RequestMapping(value="/id/{id_producto}")
	public ResponseEntity<Producto> getProductoById (@PathVariable("id_producto") int id_producto) {
		Optional<Producto> optionalProducto = productoRepository.findById(id_producto);
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/nombre/{nombre}")
	public ResponseEntity<List<Producto>> getProductoByNombre (@PathVariable("nombre") String nombre) {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findByNombre(nombre));
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/borrar/{id_producto}")
	public ResponseEntity<Void> borrarProducto(@PathVariable("id_producto") int id_producto) {
		productoRepository.deleteById(id_producto);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
		Optional<Producto> optionalProducto = productoRepository.findById(producto.getId_producto());
		if(optionalProducto.isPresent()) {
			Producto productoActualizado = optionalProducto.get();
			productoActualizado.setNombre(producto.getNombre());
			productoActualizado.setPrecio(producto.getPrecio());
			productoActualizado.setStock(producto.getStock());
			productoActualizado.setLugar_procedencia(producto.getLugar_procedencia());
			productoActualizado.setFoto(producto.getFoto());
			productoRepository.save(productoActualizado);
			return ResponseEntity.ok(productoActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/dni_usuario/{dni_usuario}")
	public ResponseEntity<List<Producto>> getProductoUsuario (@PathVariable("dni_usuario") String dni_usuario) {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findByDniUsuario(dni_usuario));
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/todo")
	public ResponseEntity<List<Producto>> getTodosProductos () {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findAll());
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
