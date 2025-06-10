package com.priyanshu.patient_service.service.impl;


import com.priyanshu.patient_service.dtos.requestDTO.PatientRequestDTO;
import com.priyanshu.patient_service.dtos.responseDTO.PatientResponseDTO;
import com.priyanshu.patient_service.exceptions.DataNotFoundException;
import com.priyanshu.patient_service.exceptions.EmailAlreadyExistsException;
import com.priyanshu.patient_service.mapper.PatientMapper;
import com.priyanshu.patient_service.model.Patient;
import com.priyanshu.patient_service.repositories.PatientRepository;
import com.priyanshu.patient_service.service.PatientService;
import com.priyanshu.patient_service.utils.timeUtils.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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


    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A Patient with this email "+patientRequestDTO.getEmail()+" already exists");
        }
        Patient newPatient = patientRepository.save(PatientMapper.dtoToModel(patientRequestDTO));
        return PatientMapper.patientToDto(newPatient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Patient not found with ID: "+ id));

//        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
//            throw new EmailAlreadyExistsException(
//                    "A patient with this email " + "already exists" + patientRequestDTO.getEmail()
//            );
//        }
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(DateTimeUtils.toLocalDate(patientRequestDTO.getDateOfBirth()));

        Patient updatePatient = patientRepository.save(patient);
        return PatientMapper.patientToDto(updatePatient);
    }
}
