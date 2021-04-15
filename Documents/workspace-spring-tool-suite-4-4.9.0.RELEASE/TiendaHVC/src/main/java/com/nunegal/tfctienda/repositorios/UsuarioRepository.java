package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	@Query("select c from Cliente c where c.nombre like %?1")
	List <Usuario> findByNombre(String nombre);
	
	@Query("select c from Cliente c where c.dni_cliente like %?1")
	Usuario findByDni_cliente(String dni_cliente);
	
	@Query("select c from Cliente c where c.correo like %?1")
	Usuario findByCorreo(String correo);
	

}


