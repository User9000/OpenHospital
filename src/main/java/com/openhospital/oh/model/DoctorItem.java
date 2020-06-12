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
public class DoctorItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;
    private String specialty;
    private String practiceLicense;
    private String practiceLicenseExp;
    private LocalDate date;

    @ManyToMany
    private List<AppointmentItem> appointments;

    //private PatientItem patient;
    @OneToMany(mappedBy = "doctor")
    private List<PatientItem> patient;

    public DoctorItem(){

    }
    public DoctorItem(String name, String lastname, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }
    public DoctorItem(String name, String lastname, String phone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;

       // this.patient.add(new PatientItem(patientId,"",""));
    }

    public DoctorItem(String id, String address, String email, String specialty, String practiceLicense, String practiceLicenseExp, LocalDate date, List<AppointmentItem> appointments) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.specialty = specialty;
        this.practiceLicense = practiceLicense;
        this.practiceLicenseExp = practiceLicenseExp;
        this.date = date;
        this.appointments = appointments;
    }

    public DoctorItem(String id, String address, String email, String specialty, String practiceLicense, String practiceLicenseExp, LocalDate date) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.specialty = specialty;
        this.practiceLicense = practiceLicense;
        this.practiceLicenseExp = practiceLicenseExp;
        this.date = date;

    }
}

