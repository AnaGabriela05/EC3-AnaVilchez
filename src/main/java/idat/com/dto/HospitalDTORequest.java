package idat.com.dto;

public class HospitalDTORequest {

	private Integer id_hospitalDTO;
	private String nombreDTO;
	private String descripcionDTO;
	private String distritoDTO;
	public Integer getId_hospitalDTO() {
		return id_hospitalDTO;
	}
	public void setId_hospitalDTO(Integer id_hospitalDTO) {
		this.id_hospitalDTO = id_hospitalDTO;
	}
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	public String getDescripcionDTO() {
		return descripcionDTO;
	}
	public void setDescripcionDTO(String descripcionDTO) {
		this.descripcionDTO = descripcionDTO;
	}
	public String getDistritoDTO() {
		return distritoDTO;
	}
	public void setDistritoDTO(String distritoDTO) {
		this.distritoDTO = distritoDTO;
	}
	
}
