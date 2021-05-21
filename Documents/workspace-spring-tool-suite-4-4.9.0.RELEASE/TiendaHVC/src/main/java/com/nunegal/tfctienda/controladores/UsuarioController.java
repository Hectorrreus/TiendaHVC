package com.nunegal.tfctienda.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Carrito;
import com.nunegal.tfctienda.modelos.Usuario;
import com.nunegal.tfctienda.repositorios.CarritoRepository;
import com.nunegal.tfctienda.repositorios.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CarritoRepository carritoRepository;
			
	@PostMapping("/registrar")
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {		
		Usuario newusuario = usuarioRepository.save(usuario);
		Carrito carrito = new Carrito(usuario.getDni_usuario());
		carritoRepository.save(carrito);
		
		return ResponseEntity.ok(newusuario);
	}
	
	@RequestMapping(value="/dni/{dni_usuario}")
	public ResponseEntity<Usuario> getUsuarioByDni(@PathVariable("dni_usuario") String dni_usuario){
		Optional<Usuario> optionalusuario = usuarioRepository.findById(dni_usuario);
		if(optionalusuario.isPresent()) {
			return ResponseEntity.ok(optionalusuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@RequestMapping(value="/correo/{correo}")
	public ResponseEntity<Usuario> getUsuarioByCorreo(@PathVariable("correo") String correo){
		Optional<Usuario> optionalusuario = usuarioRepository.findByCorreo(correo);
		if(optionalusuario.isPresent()) {
			return ResponseEntity.ok(optionalusuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@DeleteMapping("/borrar")
	public ResponseEntity<Void> borrarUsuario(@PathVariable("dni_usuario") String dni_usuario ) {
		usuarioRepository.deleteById(dni_usuario);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> optionalusuario = usuarioRepository.findById(usuario.getDni_usuario());
		if(optionalusuario.isPresent()) {
			Usuario usuarioActualizado = optionalusuario.get();
			usuarioActualizado.setNombre(usuario.getNombre());
			usuarioActualizado.setApellidos(usuario.getApellidos());
			usuarioActualizado.setEsvendedor(usuarioActualizado.getEsvendedor());
			usuarioActualizado.setBeneficios(usuarioActualizado.getBeneficios());
			usuarioRepository.save(usuarioActualizado);
			return ResponseEntity.ok(usuarioActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> sacarTodosusuarios() {
		Optional<List<Usuario>> optionalusuario = Optional.of(usuarioRepository.findAll());
	if(optionalusuario.isPresent()) {
		return ResponseEntity.ok(optionalusuario.get());
	} else {
		return ResponseEntity.noContent().build();
	}
	}

}
