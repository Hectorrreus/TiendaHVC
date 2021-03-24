package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Direccion_entrega;

public interface DireccionEntregaRepository extends JpaRepository<Direccion_entrega, Integer> {

	@Query("select d from Direccion_entrega d where d.id_direccion like %?1")
	Direccion_entrega findById(String id_direccion);
	
	@Query("select d from Direccion_entrega d where d.dni_cliente like %?1")
	List <Direccion_entrega> findByDni_cliente(String dni_cliente);
	
	@Query("select d from Direccion_entrega d where d.pais like %?1")
	List <Direccion_entrega> findByPais(String pais);
	
	@Query("select d from Direccion_entrega d where d.codigopostal like %?1")
	List <Direccion_entrega> findByCodigoPostal(String codigopostal);
	
	@Query("select d from Direccion_entrega d where d.provincia like %?1")
	List <Direccion_entrega> findByProvincia(String provincia);
}
