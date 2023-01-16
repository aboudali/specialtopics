package com.springboot.elasticsearch.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO to return to view.
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AppointmentDto implements Serializable {

	@ApiModelProperty(notes = "id",hidden = true)
    private String id = UUID.randomUUID().toString();

    @ApiModelProperty(notes = "patientsFullName", example = "Ali Abboud", required = true)
    private String patientsFullName;

    @ApiModelProperty(notes = "patientsPhoneNumber", example = "0737919447", required = true)
    private String patientsPhoneNumber;

	@ApiModelProperty(notes = "patientsCNP", example = "1981004479918", required = true)
	private String patientsCNP;

	@ApiModelProperty(notes = "appointmentDate", example = "22-01-2023", required = true)
	private String appointmentDate;

    public AppointmentDto() {
    }

    public AppointmentDto(String patientsFullName, String patientsPhoneNumber, String patientsCNP, String appointmentDate) {
        this.id = UUID.randomUUID().toString();
        this.patientsFullName = patientsFullName;
        this.patientsPhoneNumber = patientsPhoneNumber;
        this.patientsCNP = patientsCNP;
        this.appointmentDate = appointmentDate;
    }


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
