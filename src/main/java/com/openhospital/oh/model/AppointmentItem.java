package com.openhospital.oh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Slf4j
@Data
@EqualsAndHashCode(of="id")
@Entity
public class AppointmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private DoctorItem doctor;
    @OneToOne(cascade = CascadeType.ALL)
    private PatientItem patient;

    private LocalDate date;
    private String building;
    private String room;
    private String details;
    private String prescription;
    private String symptoms;
    private String insurance;
   // private int doctor_id;
    //private int patient_id;

    public AppointmentItem(){

    }

    public AppointmentItem(String room) {
        this.room = room;
    }

    public AppointmentItem(String room, DoctorItem doctor, PatientItem patient) {
        this.room = room;
        this.patient= patient;
        this.doctor = doctor;
    }

    public AppointmentItem(DoctorItem doctor, PatientItem patient, LocalDate date, String building, String details, String prescription, String symptoms, String insurance) {

        this.doctor = doctor;
        this.patient=patient;
        this.date = date;
        this.building = building;
        this.details = details;
        this.prescription = prescription;
        this.symptoms = symptoms;
        this.insurance = insurance;
    }
}
