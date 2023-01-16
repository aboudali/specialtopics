package com.springboot.elasticsearch.service;

import java.util.List;

import com.springboot.elasticsearch.dto.AppointmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.springboot.elasticsearch.model.Appointment;

/**
 * The ES service.
 * 
 * 
 *
 */
public interface EsService {

	List<AppointmentDto> findAll();
	Page<Appointment> findAll(Pageable pageable);



	/**
	 * Find by ID.
	 * 
	 * @param idToFind
	 *            the ID.
	 * @return the list.
	 */
	AppointmentDto findById(String idToFind);

	/**
	 * Find by patientsCNP.
	 * 
	 * @param patientsCNP
	 *            the first name to find.
	 * 
	 * @return the list of customer matching on find.
	 */
	List<AppointmentDto> findByPatientsCNP(String patientsCNP);

	/**
	 * Find by patientsCNP with pageable.
	 * 
	 * @param patientsCNP
	 *            the first name to find.
	 * 
	 * @return the list of customer matching on find.
	 */
	Page<Appointment> findByPatientsCNP(String patientsCNP, Pageable pageable);

//	/**
//	 * Find by age.
//	 *
//	 * @param age
//	 *            the age to find.
//	 *
//	 * @return the list.
//	 */
//	List<AppointmentDto> findByAge(int age);

	void book(AppointmentDto appointmentDto);

	ResponseEntity<String> deleteByCNP(String CNP);

}
