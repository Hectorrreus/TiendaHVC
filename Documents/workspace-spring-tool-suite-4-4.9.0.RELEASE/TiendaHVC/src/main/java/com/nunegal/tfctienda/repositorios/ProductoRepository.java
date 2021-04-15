package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("select p from Producto p where p.id_producto like %?1")
	Producto findById_producto(int id_producto);
	
	@Query("select p from Producto p where p.nombre like %?1%")
	List<Producto> findByNombre(String nombre);
	
	@Query("select p from Producto p where p.dni_usuario like %?1%")
	List<Producto> findByDniUsuario(String dni_usuario);
}
