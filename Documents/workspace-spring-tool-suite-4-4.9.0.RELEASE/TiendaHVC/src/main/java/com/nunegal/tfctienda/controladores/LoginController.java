package com.nunegal.tfctienda.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Usuario;
import com.nunegal.tfctienda.repositorios.UsuarioRepository;

@RequestMapping("/login")
@RestController
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/validar/{correo}/{contrasena}")
	public ResponseEntity<Usuario> iniciarSesion(@PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena) {
		Optional<Usuario> optionalusuario = Optional.of(usuarioRepository.inicioSesionCorreo(correo, contrasena));
		if(optionalusuario.isPresent()) {
			return ResponseEntity.ok(optionalusuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}	
	}
	

}
