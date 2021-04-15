package com.nunegal.tfctienda.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Linea_pedido;
import com.nunegal.tfctienda.modelos.Pedido;
import com.nunegal.tfctienda.repositorios.LineaPedidoRepository;
import com.nunegal.tfctienda.repositorios.PedidoRepository;

@RequestMapping("/pedido")
@RestController
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	LineaPedidoRepository lineapedidoRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Pedido> crearPedido (@RequestBody Pedido pedido) {
		Pedido newpedido = pedidoRepository.save(pedido);
		return ResponseEntity.ok(newpedido);
	}
	
	@PostMapping("/registrarLineas")
	public ResponseEntity<Pedido> crearLineaPedido (@RequestBody ArrayList<Linea_pedido> lineaspedido) {
		for(int i=0; i<lineaspedido.size(); i++) {
			lineapedidoRepository.save(lineaspedido.get(i));
		}
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(value="/id/{id_pedido}")
	public ResponseEntity<Linea_pedido> getPedidoById (@PathVariable("id_pedido") int id_pedido) {
		Optional<Linea_pedido> optionalPedido = lineapedidoRepository.findById(id_pedido);
		if(optionalPedido.isPresent()) {
			return ResponseEntity.ok(optionalPedido.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/dni/{dni_cliente}")
	public ResponseEntity<Pedido> getPedidoByDni (@PathVariable("id_pedido") int id_pedido) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id_pedido);
		if(optionalPedido.isPresent()) {
			return ResponseEntity.ok(optionalPedido.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/borrar/{id_pedido}")
	public ResponseEntity<Void> borrarPedido(@PathVariable("id_pedido") int id_pedido) {
		pedidoRepository.deleteById(id_pedido);
		lineapedidoRepository.deleteById(id_pedido);
		return ResponseEntity.ok(null);
	}
	

}
