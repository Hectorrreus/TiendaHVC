package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Carrito;
import com.nunegal.tfctienda.modelos.Linea_carrito;

public interface LineaCarritoRepository extends JpaRepository<Linea_carrito, Integer>{

	@Query("select l from Linea_carrito l where l.id_lineacarrito = ?1")
	Linea_carrito findById_lineacarrito(int id_lineacarrito);
	@Query("select l from Linea_carrito l where l.id_carrito = ?1")
	List<Linea_carrito> findById_carrito(int id_carrito);
	@Query("select l from Linea_carrito l where l.id_producto = ?1")
	Linea_carrito findById_producto(int id_producto);
	@Query("select MAX(id_lineacarrito) from Linea_carrito")
	int findMaxIdLinea();

}
