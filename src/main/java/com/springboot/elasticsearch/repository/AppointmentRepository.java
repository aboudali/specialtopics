package com.springboot.elasticsearch.repository;

import java.util.List;

import com.springboot.elasticsearch.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Es repository.
 * 
 * 
 *
 */
public interface AppointmentRepository extends ElasticsearchRepository<Appointment, String> {

//	Appointment updateAppointment(String id);

	/**
	 * Show all appointments
	 *
	 * @return all appointments
	 */
	List<Appointment> findAll();

	/**
	 * Find by patientsCNP.
	 * 
	 * @param patientsCNP
	 *            the first name to find.
	 * 
	 * @return the list of customer matching on find.
	 */
	List<Appointment> findByPatientsCNP(String patientsCNP);

	/**

	 * 
	 * @param patientsCNP
	 *            the first name to find.
	 * 
	 * @return the list of customer matching on find.
	 */
	Page<Appointment> findByPatientsCNP(String patientsCNP, Pageable pageable);

	/**
	 * Find by age.
	 * 
	 * @param id
	 *            the age to find.
	 * 
	 * @return the list.
	 */


}