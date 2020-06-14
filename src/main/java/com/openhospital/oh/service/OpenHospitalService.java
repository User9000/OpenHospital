package com.openhospital.oh.service;
import com.openhospital.oh.model.AppointmentItem;
import com.openhospital.oh.model.DoctorItem;
import com.openhospital.oh.model.PatientItem;
import com.openhospital.oh.repository.AppointmentRepository;
import com.openhospital.oh.repository.DoctorRepository;
import com.openhospital.oh.repository.PatientRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenHospitalService implements OpenHospitalServiceInterface {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public OpenHospitalService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void populate(){
        patientRepository.save(new PatientItem("John","Smith","68659563"));

        doctorRepository.save(new DoctorItem("John","Wong","686565253"));
        patientRepository.save(new PatientItem("John","Smith","68659563"));
        doctorRepository.save(new DoctorItem("John","Wong","686565253"));
        patientRepository.save(new PatientItem("John","Smith","68659563"));
        doctorRepository.save(new DoctorItem("John","Wong","686565253"));
        patientRepository.save(new PatientItem("John","Smith","68659563"));
        doctorRepository.save(new DoctorItem("John","Wong","686565253"));
        patientRepository.save(new PatientItem("John","Smith","68659563"));
        appointmentRepository.save(new AppointmentItem("500"));
        appointmentRepository.save(new AppointmentItem("501"));

    }
    // == public methods
    public void addPatient(@NonNull PatientItem patient){
            patientRepository.save(patient);
    }

    public void addDoctor(@NonNull DoctorItem doctor){
            doctorRepository.save(doctor);
    }

    public void addAppointment(@NonNull AppointmentItem appointment){
        this.appointmentRepository.save(appointment);
    }


    public DoctorItem getDoctor(String id) {
        return doctorRepository.getDoctorItemById(id);
    }
    public PatientItem getPatientById(String id){
        return patientRepository.getPatientItemById(id);
    }
    public AppointmentItem getAppointmentById(String id){
        return appointmentRepository.getAppointmentItemById(id);
    }



    public  PatientItem updatePatient(PatientItem patient){
        return patientRepository.save(patient);
    }

    public DoctorItem updateDoctor(DoctorItem doctor){
        doctor.setId(doctor.getId());
      return doctorRepository.save(doctor);
    }

    public List<AppointmentItem> getAllAppointments() {

        var appointments = this.appointmentRepository.findAll();
        var apps = new ArrayList<AppointmentItem>();
        appointments.forEach(e -> apps.add(e));
        return apps;
    }

    public List<DoctorItem> getAllDoctors(){

        var doctors = this.doctorRepository.findAll();
        var docs = new ArrayList<DoctorItem>();
        doctors.forEach(e -> docs.add(e));
        return docs;
    }

    public List<PatientItem> getAllPatients(){

        var patients = patientRepository.findAll();
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }

    public List<PatientItem> getPatientsByName(String name) {
        var patients = patientRepository.getPatientItemByName(name);
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }

    public List<PatientItem> getPatientsByLastName(String lastname){
        var patients = patientRepository.getPatientItemByLastname(lastname);
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }

    public List<PatientItem> getPatientsByCity(String city){
        var patients = patientRepository.getPatientItemByCity(city);
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }

    public List<PatientItem> getPatientsByGender(String gender){
        var patients = patientRepository.getPatientItemByGender(gender);
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }

    public List<PatientItem> getPatientsByDoctor(String doctor){

        DoctorItem doctorItem = doctorRepository.getDoctorItemByPhone(doctor);

        var patients = patientRepository.getPatientItemByDoctor(doctorItem);
        var pats = new ArrayList<PatientItem>();
        patients.forEach(e -> pats.add(e));
        return pats;
    }







}
