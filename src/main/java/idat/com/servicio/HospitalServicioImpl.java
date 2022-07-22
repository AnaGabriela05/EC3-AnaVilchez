package idat.com.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.HospitalDTORequest;
import idat.com.dto.HospitalDTOResponse;
import idat.com.model.Hospital;
import idat.com.repository.HospitalRepositorio;
@Service
public class HospitalServicioImpl implements HospitalServicio{

	@Autowired
	HospitalRepositorio repo;
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		repo.save(h);
		
	}

	@Override
	public void editarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		h.setId_hospital(hospital.getId_hospitalDTO());
		repo.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> hospitalDTOlist = new ArrayList<>();
		HospitalDTOResponse h = null;
		
		if(repo.findAll().size()==0) {
			return hospitalDTOlist;
		}
		for(Hospital hospital : repo.findAll()) {
			h = new HospitalDTOResponse();
			h.setNombreDTO(hospital.getNombre());
			h.setDescripcionDTO(hospital.getDescripcion());
			h.setDistritoDTO(hospital.getDistrito());
			h.setId_hospitalDTO(hospital.getId_hospital());
			
			hospitalDTOlist.add(h);
		}
		
		return hospitalDTOlist;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Optional<Hospital> hospital = repo.findById(id);
		HospitalDTOResponse h = new HospitalDTOResponse();
		h.setNombreDTO(hospital.get().getNombre());
		h.setDescripcionDTO(hospital.get().getDescripcion());
		h.setDistritoDTO(hospital.get().getDistrito());
		h.setId_hospitalDTO(hospital.get().getId_hospital());
		return h;
	}

}
