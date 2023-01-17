package com.springboot.elasticsearch.service.impl;

import java.util.List;

import com.springboot.elasticsearch.dto.AppointmentDto;
import com.springboot.elasticsearch.factory.AppointmentFactory;
import com.springboot.elasticsearch.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.elasticsearch.repository.AppointmentRepository;
import com.springboot.elasticsearch.service.EsService;

/**
 *
 */
@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentFactory appointmentFactory;

//	@Override
//	public List<AppointmentDto> findAll() {
//		return appointmentFactory.getInstance((List<Appointment>) AppointmentRepository.findAll());
//	}

    @Override
    public List<AppointmentDto> findAll() {
        return appointmentFactory.getInstance(appointmentRepository.findAll());

    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public AppointmentDto updateAppointment(String id) {
        return null;
    }

    @Override
    public AppointmentDto findById(String idToFind) {
        return appointmentFactory.getInstance(appointmentRepository.findById(idToFind));
    }

    @Override
    public List<AppointmentDto> findByPatientsCNP(String patientsCNP) {
        return appointmentFactory.getInstance(appointmentRepository.findByPatientsCNP(patientsCNP));
    }

    @Override
    public Page<Appointment> findByPatientsCNP(String patientsCNP, Pageable pageable) {
        return appointmentRepository.findByPatientsCNP(patientsCNP, pageable);
    }

//	@Override
//	public List<AppointmentDto> findByAge(int age) {
//		return appointmentFactory.getInstance(esRepository.findByAge(age));
//	}

    @Override
    public void book(AppointmentDto appointmentDto) {
        final Appointment entity = appointmentFactory.getInstance(appointmentDto);
        appointmentRepository.save(entity);
    }







    @Override
    public ResponseEntity<String> deleteById(String CNP) {
        if (appointmentRepository.existsById(CNP)) {
            appointmentRepository.deleteById(CNP);
            return new ResponseEntity<String>("Appointment deleted.", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Appointment not found", HttpStatus.OK);
    }

}
