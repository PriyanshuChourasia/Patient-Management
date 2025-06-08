package com.priyanshu.patient_service.mapper;

import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;
import com.priyanshu.patient_service.model.Patient;
import com.priyanshu.patient_service.utils.timeUtils.DateTimeUtils;

import java.time.ZoneId;

public class PatientMapper {
    public static PatientResponseDTO patientToDto(Patient patient){
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patientDTO.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientDTO.setCreatedAt(DateTimeUtils.toEpochSecond(patient.getCreatedAt()));
        return patientDTO;
    }
}
