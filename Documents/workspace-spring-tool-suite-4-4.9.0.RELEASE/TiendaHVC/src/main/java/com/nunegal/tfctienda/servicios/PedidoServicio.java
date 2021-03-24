package com.nunegal.tfctienda.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunegal.tfctienda.modelos.Pedido;
import com.nunegal.tfctienda.repositorios.PedidoRepository;

@Service
public class PedidoServicio {
	
	@Autowired
	PedidoRepository repositorio;
	
	public Pedido crear(Pedido p) {
		return repositorio.save(p);
	}
	
	public Pedido buscarId (int id) {
		return repositorio.findById_pedido(id);
	}
	
	public List<Pedido> buscarDniCliente (String dni) {
		return repositorio.findByDni_cliente(dni);
	}
	
	public List<Pedido> buscarFecha (Date fecha) {
		return repositorio.findByFecha(fecha);
	}

}
