package idat.com.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.ClienteDTORequest;
import idat.com.dto.ClienteDTOResponse;
import idat.com.repository.ClienteRepositorio;
import idat.com.model.Cliente;

@Service
public class ClienteServicioImpl implements ClienteServicio{

	@Autowired
	ClienteRepositorio repo;
	
	@Override
	public void guardarCliente(ClienteDTORequest Cliente) {
		Cliente c = new Cliente();
		c.setNombre(Cliente.getNombreDTO());
		c.setCelular(Cliente.getCelularDTO());
		repo.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest Cliente) {
		Cliente c = new Cliente();
		c.setNombre(Cliente.getNombreDTO());
		c.setCelular(Cliente.getCelularDTO());
		c.setId_cliente(Cliente.getId_clienteDTO());
		repo.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		List<ClienteDTOResponse> clienteDTOlist = new ArrayList<>();
		ClienteDTOResponse c = null;
		
		if(repo.findAll().size()==0) {
			return clienteDTOlist;
		}
		for(Cliente Cliente : repo.findAll()) {
			c = new ClienteDTOResponse();
			c.setNombreDTO(Cliente.getNombre());
			c.setCelularDTO(Cliente.getCelular());
			c.setId_clienteDTO(Cliente.getId_cliente());
			clienteDTOlist.add(c);
		}
		
		return clienteDTOlist;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Optional<Cliente> Cliente = repo.findById(id);
		ClienteDTOResponse c = new ClienteDTOResponse();
		c.setNombreDTO(Cliente.get().getNombre());
		c.setCelularDTO(Cliente.get().getCelular());
		c.setId_clienteDTO(Cliente.get().getId_cliente());
		return c;
	}

}
