package com.tsaplev.backend.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsaplev.backend.entities.Department;
import com.tsaplev.backend.repositories.DepartmentRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DepartmentInitializer {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostConstruct
    public void init() {
        Department dep1 = new Department();
        dep1.setDepname("Короткие");
        dep1.setDepdesc("Наше нефрологическое отделение — это специализированное подразделение клиники, посвященное диагностике, лечению и уходу за пациентами с заболеваниями почек и мочевым путям.");
        departmentRepository.save(dep1);

        Department dep2 = new Department();
        dep2.setDepname("Средние");
        dep2.setDepdesc("Наше офтальмологическое отделение предоставляет широкий спектр медицинских услуг, связанных с здоровьем глаз.");
        departmentRepository.save(dep2);

        Department dep3 = new Department();
        dep3.setDepname("Длинные");
        dep3.setDepdesc("Наше отделение педиатрии предназначено для маленьких пациентов, и мы уделяем особое внимание и заботу здоровью детей.");
        departmentRepository.save(dep3);
    }
}
