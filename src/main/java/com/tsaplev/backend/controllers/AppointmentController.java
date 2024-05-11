package com.tsaplev.backend.controllers;

import com.tsaplev.backend.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tsaplev.backend.entities.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // CREATE operation
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    // READ operation
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam Map<String, String> queryParameters) {
        List<Appointment> appointments;
        if (!queryParameters.containsKey("userId")) {
            appointments = appointmentRepository.findAll();
        } else {
            Long userId = Long.parseLong(queryParameters.get("userId"));
            appointments = appointmentRepository.findAllByUserId(userId);
        }
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return new ResponseEntity<>(appointment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

