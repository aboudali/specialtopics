package com.springboot.elasticsearch.controller;

import java.util.List;

import com.springboot.elasticsearch.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.elasticsearch.service.EsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller.
 *
 */
@SwaggerDefinition(info = @Info(title = "Medical Clinic Controller", version = "v1", description = "Medical Clinic Appointment"), host = "http://localhost:8081/es")
@RestController
@RequestMapping(path = "/appointment")
@Slf4j
public class AppointmentController {

	@Autowired
	private EsService esService;

	@GetMapping("/all")
	@ApiOperation(value = "Show all appointments.")
	public List<AppointmentDto> findAll() {
		log.info("\"Showing all appointments...");
		return esService.findAll();
	}

	@GetMapping("/findBypatientsCNP/{patientsCNP}")
	@ApiOperation(value = "Find appointment by patients CNP.")
	public List<AppointmentDto> findByPatientsCNP(@PathVariable String patientsCNP) {
		log.info("\"Find appointment by patients CNP...");
		return esService.findByPatientsCNP(patientsCNP);
	}

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "Find appointment by ID.")
	public AppointmentDto findById(@PathVariable String id) {
		return esService.findById(id);
	}

	@PostMapping("/book")
	@ApiOperation(value = "Book a new appointment.")
	public void saveIndex(@RequestBody AppointmentDto appointmentDto) {
		esService.book(appointmentDto);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete appointment by Id.")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		return esService.deleteById(id);
	}

//
//	@PutMapping("/update/{id}")
//	@ApiOperation(value = "Update appointment by Id.")
//	public ResponseEntity<String> updateAppointment(@PathVariable String id) {
//		return esService.updateAppointment(id);
//	}


	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update appointment by Id.")
	public AppointmentDto updateAppointment(@PathVariable String id) {
//		return esService.updateAppointment(id);
		return null;
	}



}
