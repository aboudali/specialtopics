package com.springboot.elasticsearch.factory.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springboot.elasticsearch.dto.AppointmentDto;
import com.springboot.elasticsearch.factory.AppointmentFactory;
import com.springboot.elasticsearch.model.Appointment;
import org.springframework.stereotype.Component;

/**
 * Converter implementation.
 *
 *   "patientsFullName": "Ali Abboud",
 *   "patientsPhoneNumber": "791234567",
 *   "patientsCNP": "1234567891123",
 *   "appointmentDate": "dd-mm-yyyy"
 *
 */
@Component
public class AppointmentFactoryImpl implements AppointmentFactory {

	@Override
	public AppointmentDto getInstance() {
		return new AppointmentDto();
	}

	@Override
	public AppointmentDto getInstance(Appointment domainObject) {
		final AppointmentDto instance = getInstance();
		instance.setPatientsFullName(domainObject.getPatientsFullName());
		instance.setPatientsPhoneNumber(domainObject.getPatientsPhoneNumber());
		instance.setPatientsCNP(domainObject.getPatientsCNP());
		instance.setAppointmentDate(domainObject.getAppointmentDate());
		return instance;
	}

	@Override
	public AppointmentDto getInstance(Optional<Appointment> listAppointment) {
		if (listAppointment.isPresent()) {
			return getInstance(listAppointment.get());
		}
		return null;
	}

	@Override
	public Appointment getInstance(AppointmentDto appointmentDto) {
		final Appointment appointmentDo = new Appointment();
		appointmentDo.setPatientsFullName(appointmentDto.getPatientsFullName());
		appointmentDo.setPatientsPhoneNumber(appointmentDto.getPatientsPhoneNumber());
		appointmentDo.setPatientsCNP(appointmentDto.getPatientsCNP());
		appointmentDo.setAppointmentDate(appointmentDto.getAppointmentDate());
		return appointmentDo;
	}

	@Override
	public List<AppointmentDto> getInstance(List<Appointment> listAppointment) {
		final List<AppointmentDto> listResponse = new ArrayList<>();
		if (listAppointment.isEmpty()) {
			return listResponse;
		}

		listAppointment.forEach(domainObject -> {
			listResponse.add(getInstance(domainObject));
		});

		return listResponse;
	}

}
