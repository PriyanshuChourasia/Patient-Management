package com.priyanshu.patient_service.service.impl;


import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;
import com.priyanshu.patient_service.mapper.PatientMapper;
import com.priyanshu.patient_service.model.Patient;
import com.priyanshu.patient_service.repositories.PatientRepository;
import com.priyanshu.patient_service.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "Patient-Service")
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAll(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(patient -> PatientMapper.patientToDto(patient)).toList();
        return patientResponseDTOS;
    }
}
