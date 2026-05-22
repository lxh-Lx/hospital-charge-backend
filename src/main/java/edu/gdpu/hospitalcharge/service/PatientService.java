package edu.gdpu.hospitalcharge.service;

import edu.gdpu.hospitalcharge.entity.Patient;

public interface PatientService {
    Patient getPatientById(Integer patientId);
}