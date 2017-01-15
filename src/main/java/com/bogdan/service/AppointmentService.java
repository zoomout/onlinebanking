package com.bogdan.service;

import com.bogdan.domain.Appointment;

import java.util.List;

/**
 * Created by zoomout on 1/11/17.
 */
public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}
