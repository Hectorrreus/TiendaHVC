package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	@Query("select u from Usuario u where u.nombre like %?1")
	List <Usuario> findByNombre(String nombre);
	
	@Query("select u from Usuario u where u.dni_usuario like %?1")
	Usuario findByDni_usuario(String dni_usuario);
	
	@Query("select u from Usuario u where u.correo like %?1")
	Usuario findByCorreo(String correo);
	

}


