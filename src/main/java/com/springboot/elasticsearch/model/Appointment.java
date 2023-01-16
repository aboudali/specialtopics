package com.springboot.elasticsearch.model;

import java.util.UUID;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

/**
 * Domain object definition.
 *
 * {
 *   "patientsFullName": "Ali Abboud",
 *   "patientsPhoneNumber": "791234567",
 *   "patientsCNP": "1234567891123",
 *   "appointmentDate": "dd-mm-yyyy"
 * }
 * 
 *
 */
@Data
@Document(indexName = "index_spring_es")
public class Appointment {
	@Id
	private String id = UUID.randomUUID().toString();

	private String patientsFullName;
	private String patientsPhoneNumber;
	private String patientsCNP;
	private String appointmentDate;

	public String getId() {
		return id;
	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getPatientsFullName() {
		return patientsFullName;
	}

	public void setPatientsFullName(String patientsFullName) {
		this.patientsFullName = patientsFullName;
	}

	public String getPatientsPhoneNumber() {
		return patientsPhoneNumber;
	}

	public void setPatientsPhoneNumber(String patientsPhoneNumber) {
		this.patientsPhoneNumber = patientsPhoneNumber;
	}

	public String getPatientsCNP() {
		return patientsCNP;
	}

	public void setPatientsCNP(String patientsCNP) {
		this.patientsCNP = patientsCNP;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
}
