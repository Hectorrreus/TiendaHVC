package com.nunegal.tfctienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

	@Query("select c from Carrito c where c.id_carrito like %?1")
	Carrito findById_carrito(int id_carrito);
	
	@Query("select c from Carrito c where c.dni_usuario like %?1")
	Carrito findByDni_usuario(String dni_usuario);
	
}
