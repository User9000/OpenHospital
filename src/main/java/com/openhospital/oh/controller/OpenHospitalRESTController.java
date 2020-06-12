package com.openhospital.oh.controller;

import com.openhospital.oh.model.AppointmentItem;
import com.openhospital.oh.model.DoctorItem;
import com.openhospital.oh.model.PatientItem;
import com.openhospital.oh.service.OpenHospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OpenHospitalRESTController {

    @Autowired
    private OpenHospitalService openHospitalRestService;

    @GetMapping("/api/patients")
    public List<PatientItem> getAllPatients() {
        return openHospitalRestService.getAllPatients();
    }

    @GetMapping("/api/doctors")
    public List<DoctorItem> getAllDoctors() {
        return openHospitalRestService.getAllDoctors();
    }
    @GetMapping("/api/appointments")
    public List<AppointmentItem> getAllAppointments() {
        return openHospitalRestService.getAllAppointments();
    }
    @PostMapping("/api/addpatient")
    public void addpatient(){
        log.info("Adding a patient on REST Controller");
    }

    @GetMapping("/api/getPatientByName")
    public List<PatientItem> patientByName(@RequestParam String name){
        return openHospitalRestService.getPatientsByName(name);
    }

    @GetMapping("/api/getPatientByLastName")
    public List<PatientItem> patientByLastName(@RequestParam String lastname){
        return openHospitalRestService.getPatientsByLastName(lastname);
    }

    @GetMapping("/api/getPatientByCity")
    public List<PatientItem> patientByCity(@RequestParam String city){
        return openHospitalRestService.getPatientsByCity(city);
    }

    @GetMapping("/api/getPatientByGender")
    public List<PatientItem> patientByGender(@RequestParam String gender){
        return openHospitalRestService.getPatientsByGender(gender);
    }


    @GetMapping("/api/getPatientByDoctor")
    public List<PatientItem> patientByDoctor(@RequestParam String doctor){
        return openHospitalRestService.getPatientsByDoctor(doctor);
    }



}
