package com.nunegal.tfctienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunegal.tfctienda.modelos.Linea_pedido;
import com.nunegal.tfctienda.modelos.Pedido;

public interface LineaPedidoRepository extends JpaRepository<Linea_pedido, Integer>{

	@Query("select l from Linea_pedido l where l.id_lineapedido like %?1")
	Pedido findById_lineapedido(int id_lineapedido);
	@Query("select l from Linea_pedido l where l.id_pedido like %?1")
	List <Pedido> findById_pedido(int id_pedido);
}
