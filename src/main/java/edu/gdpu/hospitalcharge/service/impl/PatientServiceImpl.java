package edu.gdpu.hospitalcharge.service.impl;

import edu.gdpu.hospitalcharge.entity.Patient;
import edu.gdpu.hospitalcharge.mapper.PatientMapper;
import edu.gdpu.hospitalcharge.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientMapper.selectById(patientId);
    }
}