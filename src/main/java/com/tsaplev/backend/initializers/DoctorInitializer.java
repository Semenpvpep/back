package com.tsaplev.backend.initializers;

import com.tsaplev.backend.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsaplev.backend.entities.Department;
import com.tsaplev.backend.entities.Doctor;

import jakarta.annotation.PostConstruct;

@Component
public class DoctorInitializer {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostConstruct
    public void init() {
        // department 1 
        Department dep1 = new Department();
        dep1.setId((long)(1));

        Doctor doc1 = new Doctor();
        doc1.setDoctorname("Ултас Исмаглы");
        doc1.setDepartment(dep1);

        Doctor doc2 = new Doctor();
        doc2.setDoctorname("Баржакбил Нияев");
        doc2.setDepartment(dep1);

        Doctor doc3 = new Doctor();
        doc3.setDoctorname("Абдаренше Ахмететов");
        doc3.setDepartment(dep1);

        doctorRepository.save(doc1);
        doctorRepository.save(doc2);
        doctorRepository.save(doc3);

        // department 2
        Department dep2 = new Department();
        dep2.setId((long)(2));

        Doctor doc4 = new Doctor();
        doc4.setDoctorname("Монлетияр Есимбай");
        doc4.setDepartment(dep2);

        Doctor doc5 = new Doctor();
        doc5.setDoctorname("Азамназ Сериаев");
        doc5.setDepartment(dep2);

        Doctor doc6 = new Doctor();
        doc6.setDoctorname("Архлетияр Ашиетов");
        doc6.setDepartment(dep2);

        doctorRepository.save(doc4);
        doctorRepository.save(doc5);
        doctorRepository.save(doc6);

        // department 3
        Department dep3 = new Department();
        dep3.setId((long)(3));

        Doctor doc7 = new Doctor();
        doc7.setDoctorname("Жарфу Омарлаев");
        doc7.setDepartment(dep3);

        Doctor doc8 = new Doctor();
        doc8.setDoctorname("Насуп Валимов");
        doc8.setDepartment(dep3);

        Doctor doc9 = new Doctor();
        doc9.setDoctorname("Есназа Идрибеков");
        doc9.setDepartment(dep3);

        doctorRepository.save(doc7);
        doctorRepository.save(doc8);
        doctorRepository.save(doc9);
    }
}
