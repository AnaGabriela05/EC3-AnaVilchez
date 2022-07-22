package idat.com.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.UsuarioClienteDTORequest;
import idat.com.dto.UsuarioClienteDTOResponse;
import idat.com.repository.ClienteRepositorio;
import idat.com.repository.UsuarioClienteRepositorio;
import idat.com.model.Cliente;
import idat.com.model.UsuarioCliente;

@Service
public class UsuarioClienteServicioImpl implements UsuarioClienteServicio{

	@Autowired
	UsuarioClienteRepositorio repo;
	
	@Autowired
	ClienteRepositorio repoCli;
	
	@Override
	public void guardarUsuarioCliente(UsuarioClienteDTORequest usuarioCliente) {
		UsuarioCliente u = new UsuarioCliente();
		u.setUsuario(usuarioCliente.getUsuarioDTO());
		u.setPassword(usuarioCliente.getPasswordDTO());
		u.setRol(usuarioCliente.getRolDTO());
		
		Optional<Cliente> cliente = repoCli.findById(usuarioCliente.getId_clienteDTO());
		u.setClientes(cliente.get());
		repo.save(u);
	}

	@Override
	public void editarUsuarioCliente(UsuarioClienteDTORequest usuarioCliente) {
		UsuarioCliente u = new UsuarioCliente();
		u.setUsuario(usuarioCliente.getUsuarioDTO());
		u.setPassword(usuarioCliente.getPasswordDTO());
		u.setRol(usuarioCliente.getRolDTO());
		repo.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUsuarioCliente(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<UsuarioClienteDTOResponse> listarUsuarioCliente() {
		List<UsuarioClienteDTOResponse> usuarioClienteDTOlist = new ArrayList<>();
		UsuarioClienteDTOResponse u = null;
		
		if(repo.findAll().size()==0) {
			return usuarioClienteDTOlist;
		}
		for(UsuarioCliente usuarioCliente : repo.findAll()) {
			u = new UsuarioClienteDTOResponse();
			u.setUsuarioDTO(usuarioCliente.getUsuario());
			u.setPasswordDTO(usuarioCliente.getPassword());
			u.setRolDTO(usuarioCliente.getRol());
			u.setId_usuario(usuarioCliente.getId_usuario());
			usuarioClienteDTOlist.add(u);
		}
		
		return usuarioClienteDTOlist;
	}

	@Override
	public UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id) {
		Optional<UsuarioCliente> usuarioCliente = repo.findById(id);
		UsuarioClienteDTOResponse u = new UsuarioClienteDTOResponse();
		u.setUsuarioDTO(usuarioCliente.get().getUsuario());
		u.setPasswordDTO(usuarioCliente.get().getPassword());
		u.setRolDTO(usuarioCliente.get().getRol());
		u.setId_usuario(usuarioCliente.get().getId_usuario());
		return u;
	}

}
