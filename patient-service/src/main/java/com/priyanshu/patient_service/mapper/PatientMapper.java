package com.priyanshu.patient_service.mapper;

import com.priyanshu.patient_service.dtos.requestDTO.PatientRequestDTO;
import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;
import com.priyanshu.patient_service.model.Patient;
import com.priyanshu.patient_service.utils.timeUtils.DateTimeUtils;



public class PatientMapper {
    public static PatientResponseDTO patientToDto(Patient patient){
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        if(patient.getCreatedAt() == null){
            patientDTO.setCreatedAt(null);
        }
        else{
            patientDTO.setCreatedAt(DateTimeUtils.toEpochSecond(patient.getCreatedAt()));
        }
        return patientDTO;
    }


    public static Patient dtoToModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(DateTimeUtils.toLocalDate(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(DateTimeUtils.toLocalDate(patientRequestDTO.getRegisteredDate()));
        return patient;
    }
}
