package com.priyanshu.patient_service.service;


import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    List<PatientResponseDTO> getAll();
}
