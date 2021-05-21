package com.nunegal.tfctienda.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query("select p from Pedido p where p.id_pedido like %?1")
	Pedido findById_pedido(int id_pedido);
	
	@Query("select p from Pedido p where p.dni_usuario like %?1")
	List <Pedido> findByDni_usuario(String dni_usuario);
	
	@Query("select p from Pedido p where p.fecha like %?1")
	List <Pedido> findByFecha (Date fecha);
}
