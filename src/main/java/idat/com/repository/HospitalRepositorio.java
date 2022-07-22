package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Hospital;

@Repository
public interface HospitalRepositorio extends JpaRepository<Hospital, Integer> {

}
