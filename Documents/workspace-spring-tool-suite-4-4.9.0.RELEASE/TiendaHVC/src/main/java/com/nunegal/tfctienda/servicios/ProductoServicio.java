package com.nunegal.tfctienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunegal.tfctienda.modelos.Producto;
import com.nunegal.tfctienda.repositorios.ProductoRepository;

@Service
public class ProductoServicio {

	@Autowired
	ProductoRepository repositorio;
	
	public Producto guardar(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto buscarId_producto(int id_producto) {
		return repositorio.findById_producto(id_producto);
	}
	
	public List<Producto> buscarNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}
}
