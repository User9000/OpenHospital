
package com.openhospital.oh.controller;
import com.openhospital.oh.model.AppointmentItem;
import com.openhospital.oh.model.DoctorItem;
import com.openhospital.oh.model.PatientItem;
import com.openhospital.oh.service.OpenHospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.time.LocalDate;
@Slf4j
@Controller
public class OpenHospitalController {

    private final OpenHospitalService hospitalService;

    @Autowired
    public OpenHospitalController(OpenHospitalService hospitalService) {
        this.hospitalService  = hospitalService;
        this.hospitalService.populate();
    }

    @GetMapping("/appointments")
      public String appointmentView(@RequestParam(required = false, defaultValue = "-1")
                        int id, Model model) {
            model.addAttribute("appointment", hospitalService.getAllAppointments());
            return "appointments";
        }

    @GetMapping("/doctors")
    public String doctorsView(@RequestParam(required = false, defaultValue = "-1")
                                          int id, Model model) {
        model.addAttribute("doctor", hospitalService.getAllDoctors());
        return "doctors";
    }

    @GetMapping("/patients")
    public String patientsView(@RequestParam(required = false, defaultValue = "-1")                                      int id, Model model) {
        model.addAttribute("patient", hospitalService.getAllPatients());
        model.addAttribute("doctors", hospitalService.getAllDoctors());
        return "patients";
    }



        @GetMapping("/addDoctor")
        public String addEditDoctor(@RequestParam(required = false, defaultValue = "-1") String id, Model model){
            log.info("Adding a doctor");
            log.info("This is the id passed {}", id);

            DoctorItem doctor = hospitalService.getDoctor(id);

            log.info("Doctor ={}", doctor);
            if(doctor == null) {
             doctor = new DoctorItem("", "", "");
            }
            model.addAttribute("DoctorItem", doctor);
            log.info("Doctor.ID = {}", doctor.getId());
        return "add_doctor";
     }

     @PostMapping("/addDoctor")
    public String proccessDoctor(@ModelAttribute("DoctorItem") DoctorItem doctor){

         log.info("Doctor.ID = {}", doctor.getId());
            if(doctor.getId() == "0"){
                log.info("Adding a new Doctor = {}", doctor);
                hospitalService.addDoctor(doctor);
            }
            else{
                log.info("Doctor.ID = {}", doctor.getId());
                log.info("Updating Doctor = {}", doctor);
                hospitalService.updateDoctor(doctor);
            }
        return  "redirect:/" + "doctors";
     }

    @GetMapping("/addPatient")
    public String addEditPatient(@RequestParam(required = false, defaultValue = "-1") String id, Model model){
        log.info("Adding patient");

        PatientItem patient = hospitalService.getPatientById(id);

        if(patient == null) {
            patient = new PatientItem("", "", "");
        }
        model.addAttribute("doctors", hospitalService.getAllDoctors());
        model.addAttribute("PatientItem", patient);
        return "add_patient";
    }

    @PostMapping("/addPatient")
    public String processPatient(@RequestParam(value = "doctor_id", required = false, defaultValue ="null" ) String doctor_id, @ModelAttribute("PatientItem") PatientItem patient){

        log.info("add_patient ={}", patient);
        log.info("doctor_id = {}", doctor_id);

        if (patient.getId() == "0") {
            if(doctor_id != "null"){

                patient.setDoctor(hospitalService.getDoctor(doctor_id));
            }
            hospitalService.addPatient(patient);
        }
        else{
            if(doctor_id != "null"){
                patient.setDoctor(hospitalService.getDoctor(doctor_id));
            }
            hospitalService.updatePatient(patient);
        }

        return  "redirect:/" + "patients";
    }

    @GetMapping("/addAppointment")
    public String addEditAppointment(@RequestParam(required = false, defaultValue = "-1") String id, Model model){
        log.info("GET add appointment");
        //AppointmentItem appointment = null;
        AppointmentItem appointment  = hospitalService.getAppointmentById(id);
        if(appointment == null) {
            appointment = new AppointmentItem("");
        }
        model.addAttribute("AppointmentItem", appointment);
        return "add_appointment";
    }

    @PostMapping("/addAppointment")
    public String processPatient(@ModelAttribute("AppointmentItem") AppointmentItem appointment){
        log.info("add_appointment ={}", appointment);
        hospitalService.addAppointment(appointment);
        return  "redirect:/" + "appointments";
    }





}
