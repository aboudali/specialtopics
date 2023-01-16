package com.springboot.elasticsearch.factory;

import java.util.List;
import java.util.Optional;

import com.springboot.elasticsearch.dto.AppointmentDto;
import com.springboot.elasticsearch.model.Appointment;

/**
 * Factory to convert domain object to domain transfer object.
 * 
 * 
 *
 */
public interface AppointmentFactory {


	AppointmentDto getInstance();

	AppointmentDto getInstance(Appointment domainObject);

	AppointmentDto getInstance(Optional<Appointment> listAppointment);

	Appointment getInstance(AppointmentDto appointmentDto);

	List<AppointmentDto> getInstance(List<Appointment> listAppointment);

}
