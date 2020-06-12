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
public class PatientItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String lastname;
    private String gender;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String country;


    private String phone;
    private String email;
    private String age;
    private String weight;
    private String temperature;
    private String height;
    private String DOB;
    private String workplace;
    private LocalDate date;

    @ManyToMany
    private List<AppointmentItem> appointments;

    @ManyToOne
    private DoctorItem doctor;

    public PatientItem() {

    }

    public PatientItem( String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public PatientItem( String id,  String name, String lastname) {
        this.setId(id);
        this.setLastname(lastname);
        this.setName(name);
    }


    public PatientItem(String id, String name, String lastname, String gender, String address, String phone, String email, String age, String weight, String temperature, String height, String DOB, String workplace, LocalDate date, List<AppointmentItem> appointments, DoctorItem doctor) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
        this.height = height;
        this.DOB = DOB;
        this.workplace = workplace;
        this.date = date;
        this.appointments = appointments;
        this.doctor = doctor;
    }

    public PatientItem(String id, String name, String lastname, String gender, String address, String zipcode, String city, String state, String country, String phone, String email, String age, String weight, String temperature, String height, String DOB, String workplace, LocalDate date, List<AppointmentItem> appointments, DoctorItem doctor) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
        this.height = height;
        this.DOB = DOB;
        this.workplace = workplace;
        this.date = date;
        this.appointments = appointments;
        this.doctor = doctor;
    }
}
