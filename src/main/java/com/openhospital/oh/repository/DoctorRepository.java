package com.openhospital.oh.repository;

import com.openhospital.oh.model.PatientItem;
import org.springframework.data.repository.CrudRepository;
import com.openhospital.oh.model.DoctorItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorItem,String> {

    //Find all patients
   public List<DoctorItem> getDoctorItemByName(String name);

   public List<DoctorItem>  getDoctorItemByLastname(String name);

   public DoctorItem  getDoctorItemById(String id);

   public DoctorItem  getDoctorItemByPhone(String phone);



   public List<DoctorItem>  getDoctorItemByEmail(String email);


}
