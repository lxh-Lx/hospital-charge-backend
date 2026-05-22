package edu.gdpu.hospitalcharge.controller;

import edu.gdpu.hospitalcharge.common.Result;
import edu.gdpu.hospitalcharge.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientId}")
    public Result getPatientById(@PathVariable Integer patientId) {
        return Result.success(patientService.getPatientById(patientId));
    }
}