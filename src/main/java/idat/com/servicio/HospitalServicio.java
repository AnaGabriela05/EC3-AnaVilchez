package idat.com.servicio;

import java.util.List;

import idat.com.dto.HospitalDTORequest;
import idat.com.dto.HospitalDTOResponse;

public interface HospitalServicio {

	public void guardarHospital(HospitalDTORequest hospital);
	public void editarHospital(HospitalDTORequest hospital);
	
	public void eliminarHospital(Integer id);
	
	public List<HospitalDTOResponse> listarHospital();
	public HospitalDTOResponse obtenerHospitalId(Integer id);
}
