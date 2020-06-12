package com.openhospital.oh.repository;
import com.openhospital.oh.model.DoctorItem;
import com.openhospital.oh.model.PatientItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PatientRepository extends CrudRepository<PatientItem, String> {

    public List<PatientItem> getPatientItemByName(String name);

    public PatientItem getPatientItemById(String id);

    public List<PatientItem> getPatientItemByLastname(String name);

    public List<PatientItem> getPatientItemByDoctor(DoctorItem doctor);

    public List<PatientItem> getPatientItemByGender(String gender);

    public List<PatientItem> getPatientItemByCity(String city);



}
