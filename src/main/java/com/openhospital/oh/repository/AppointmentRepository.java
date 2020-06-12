package com.openhospital.oh.repository;
import com.openhospital.oh.model.AppointmentItem;
import com.openhospital.oh.model.DoctorItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentItem, String> {
    public AppointmentItem getAppointmentItemById(String id);
}
