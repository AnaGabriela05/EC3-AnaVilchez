package idat.com.servicio;

import java.util.List;

import idat.com.dto.UsuarioClienteDTORequest;
import idat.com.dto.UsuarioClienteDTOResponse;

public interface UsuarioClienteServicio {

	public void guardarUsuarioCliente(UsuarioClienteDTORequest usuarioCliente);
	public void editarUsuarioCliente(UsuarioClienteDTORequest usuarioCliente);
	
	public void eliminarUsuarioCliente(Integer id);
	
	public List<UsuarioClienteDTOResponse> listarUsuarioCliente();
	public UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id);
	
}
