package idat.com.dto;

public class ClienteDTORequest {
	private Integer id_clienteDTO;
	private String nombreDTO;
	private String celularDTO;
	public Integer getId_clienteDTO() {
		return id_clienteDTO;
	}
	public void setId_clienteDTO(Integer id_clienteDTO) {
		this.id_clienteDTO = id_clienteDTO;
	}
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	public String getCelularDTO() {
		return celularDTO;
	}
	public void setCelularDTO(String celularDTO) {
		this.celularDTO = celularDTO;
	}
}
