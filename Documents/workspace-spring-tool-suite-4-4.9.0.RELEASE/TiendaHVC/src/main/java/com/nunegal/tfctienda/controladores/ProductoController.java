package com.nunegal.tfctienda.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunegal.tfctienda.modelos.Producto;
import com.nunegal.tfctienda.repositorios.ProductoRepository;

@RequestMapping("/producto")

@RestController
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = new FileInputStream(source);
        OutputStream output = new FileOutputStream(dest);
        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }
        input.close();
        output.close();
    }
	
	private static File pasarImagen(String imagen64) {
        String[] strings = imagen64.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        //convert base64 string to binary data
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = "/TiendaHVC/src/main/java/com/nunegal/tfctienda/imagenes" + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return file;
    }
	
	
	@PostMapping("/registrarfoto")
	public ResponseEntity<Producto> crearProductoFoto (@RequestBody Producto producto) {
		File foto = pasarImagen(producto.getFoto());
		File destino = new File("/TiendaHVC/src/main/java/com/nunegal/tfctienda/imagenes");
		try {
			copyFileUsingFileStreams(foto, destino);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setFoto("/TiendaHVC/src/main/java/com/nunegal/tfctienda/imagenes" + foto.getName());
		Producto newproducto = productoRepository.save(producto);
		return ResponseEntity.ok(newproducto);
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Producto> crearProducto (@RequestBody Producto producto) {
		//if(producto.getFoto()!=null) {
			//producto.setFoto("/TiendaHVC/src/main/java/com/nunegal/tfctienda/imagenes" + producto.getFoto());
			//Producto newproducto = productoRepository.save(producto);
		//}
		Producto newproducto = productoRepository.save(producto);
		return ResponseEntity.ok(newproducto);
	}
	
	@RequestMapping(value="/id/{id_producto}")
	public ResponseEntity<Producto> getProductoById (@PathVariable("id_producto") int id_producto) {
		Optional<Producto> optionalProducto = productoRepository.findById(id_producto);
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/nombre/{nombre}")
	public ResponseEntity<List<Producto>> getProductoByNombre (@PathVariable("nombre") String nombre) {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findByNombre(nombre));
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/borrar/{id_producto}")
	public ResponseEntity<Void> borrarProducto(@PathVariable("id_producto") int id_producto) {
		productoRepository.deleteById(id_producto);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
		Optional<Producto> optionalProducto = productoRepository.findById(producto.getId_producto());
		if(optionalProducto.isPresent()) {
			Producto productoActualizado = optionalProducto.get();
			productoActualizado.setNombre(producto.getNombre());
			productoActualizado.setPrecio(producto.getPrecio());
			productoActualizado.setStock(producto.getStock());
			productoActualizado.setLugar_procedencia(producto.getLugar_procedencia());
			productoActualizado.setDescripcion(producto.getDescripcion());
			productoActualizado.setFoto(producto.getFoto());
			productoRepository.save(productoActualizado);
			return ResponseEntity.ok(productoActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/dni_usuario/{dni_usuario}")
	public ResponseEntity<List<Producto>> getProductoUsuario (@PathVariable("dni_usuario") String dni_usuario) {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findByDniUsuario(dni_usuario));
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/todo")
	public ResponseEntity<List<Producto>> getTodosProductos () {
		Optional<List<Producto>> optionalProducto = Optional.of(productoRepository.findAll());
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
