package idat.com.servicio;

import java.util.List;

import idat.com.dto.ClienteDTORequest;
import idat.com.dto.ClienteDTOResponse;

public interface ClienteServicio {

	public void guardarCliente(ClienteDTORequest Cliente);
	public void editarCliente(ClienteDTORequest Cliente);
	
	public void eliminarCliente(Integer id);
	
	public List<ClienteDTOResponse> listarClientes();
	public ClienteDTOResponse obtenerClienteId(Integer id);
	
}
