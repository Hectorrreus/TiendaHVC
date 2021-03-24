package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String>{
	
	@Query("select v from Vendedor v where v.nombre like %?1")
	List <Vendedor> findByNombre(String nombre);
	
	@Query("select v from Vendedor v where v.dni_vendedor like %?1")
	Vendedor findByDni_Vendedor(String dni_vendedor);
	
	@Query("select v from Vendedor v where v.correo like %?1")
	Vendedor findByCorreo(String correo);
	
}
