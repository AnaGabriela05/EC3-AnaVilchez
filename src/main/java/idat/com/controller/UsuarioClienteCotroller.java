package idat.com.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.com.dto.UsuarioClienteDTORequest;
import idat.com.dto.UsuarioClienteDTOResponse;
import idat.com.servicio.UsuarioClienteServicioImpl;

@RestController
@RequestMapping("/usuariocliente")
@CrossOrigin(origins = "*")
public class UsuarioClienteCotroller {
	@Autowired
	UsuarioClienteServicioImpl serv;
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Object> registrar(@RequestBody UsuarioClienteDTORequest UsuarioCliente){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.guardarUsuarioCliente(UsuarioCliente);
		exito.put("message", "UsuarioCliente registrado");
		return new ResponseEntity<>(exito,HttpStatus.CREATED);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Registrar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}

	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Object> actualizar(@RequestBody UsuarioClienteDTORequest UsuarioCliente){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.editarUsuarioCliente(UsuarioCliente);
		exito.put("message", "UsuarioCliente actualizado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Actualizar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> listarId(@PathVariable Integer id){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		UsuarioClienteDTOResponse UsuarioCliente =serv.obtenerUsuarioClienteId(id);
		exito.put("content", UsuarioCliente);
		exito.put("message", "UsuarioCliente encontrado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error UsuarioCliente no encontrado");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<Object> listar(){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		List<UsuarioClienteDTOResponse> UsuarioCliente =serv.listarUsuarioCliente();
		exito.put("content", UsuarioCliente);
		exito.put("message", "Exito");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable Integer id){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.eliminarUsuarioCliente(id);
		exito.put("message", "UsuarioCliente eliminado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al eliminar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
}
