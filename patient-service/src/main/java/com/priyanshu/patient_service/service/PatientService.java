package com.priyanshu.patient_service.service;


import com.priyanshu.patient_service.dtos.requestDTO.PatientRequestDTO;
import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<PatientResponseDTO> getAll();

    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);

    PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO);
}
