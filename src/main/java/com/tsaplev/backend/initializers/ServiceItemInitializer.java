package com.tsaplev.backend.initializers;

import com.tsaplev.backend.repositories.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsaplev.backend.entities.Department;
import com.tsaplev.backend.entities.ServiceItem;

import jakarta.annotation.PostConstruct;

@Component
public class ServiceItemInitializer {
    @Autowired
    private ServiceItemRepository serviceItemRepository;

    @PostConstruct
    public void init() {
        // department 1
        Department dep1 = new Department();
        dep1.setId((long)(1));

        ServiceItem ser1 = new ServiceItem();
        ser1.setServicename("Под ноль");
        ser1.setSerdesc("Исследование почек с использованием ультразвуковой техники для выявления патологий и состояния органов.");
        ser1.setDepartment(dep1);
        ser1.setPrice((long)(100));

        ServiceItem ser2 = new ServiceItem();
        ser2.setServicename("Бокс");
        ser2.setSerdesc("Осмотр и консультация специалиста нефролога с проведением ультразвукового скрининга почек для диагностики и составления плана лечения.");
        ser2.setDepartment(dep1);
        ser2.setPrice((long)(150));

        ServiceItem ser3 = new ServiceItem();
        ser3.setServicename("Полубокс");
        ser3.setSerdesc("Комплексное лечение хронической почечной недостаточности, включая медикаментозную терапию, диету и рекомендации по образу жизни.");
        ser3.setDepartment(dep1);
        ser3.setPrice((long)(200));

        serviceItemRepository.save(ser1);
        serviceItemRepository.save(ser2);
        serviceItemRepository.save(ser3);

        // department 2
        Department dep2 = new Department();
        dep2.setId((long)(2));

        ServiceItem ser4 = new ServiceItem();
        ser4.setServicename("Шапочка");
        ser4.setSerdesc("Осмотр и консультация офтальмолога для выявления возможных проблем с зрением и рекомендаций по их решению.");
        ser4.setDepartment(dep2);
        ser4.setPrice((long)(250));

        ServiceItem ser5 = new ServiceItem();
        ser5.setServicename("Чёлкой на бок");
        ser5.setSerdesc("Хирургическая процедура для коррекции зрения с использованием лазерной технологии.");
        ser5.setDepartment(dep2);
        ser5.setPrice((long)(250));

        ServiceItem ser6 = new ServiceItem();
        ser6.setServicename("Канадка");
        ser6.setSerdesc("Диагностика и комплексное лечение глаукомы, включая медикаментозную терапию и хирургические методы.");
        ser6.setDepartment(dep2);
        ser6.setPrice((long)(200));

        serviceItemRepository.save(ser4);
        serviceItemRepository.save(ser5);
        serviceItemRepository.save(ser6);

        // department 3
        Department dep3 = new Department();
        dep3.setId((long)(3));

        ServiceItem ser7 = new ServiceItem();
        ser7.setServicename("Патлатка");
        ser7.setSerdesc("Плановый медицинский осмотр детей раннего возраста для оценки их развития и состояния здоровья.");
        ser7.setDepartment(dep3);
        ser7.setPrice((long)(650));

        ServiceItem ser8 = new ServiceItem();
        ser8.setServicename("Каре");
        ser8.setSerdesc("Введение вакцин для защиты от различных детских инфекций в соответствии с графиком вакцинации.");
        ser8.setDepartment(dep3);
        ser8.setPrice((long)(800));

        ServiceItem ser9 = new ServiceItem();
        ser9.setServicename("Маллет");
        ser9.setSerdesc("Диагностика и комплексное лечение респираторных заболеваний у детей, включая простуду, бронхит и пневмонию.");
        ser9.setDepartment(dep3);
        ser9.setPrice((long)(5000));

        serviceItemRepository.save(ser7);
        serviceItemRepository.save(ser8);
        serviceItemRepository.save(ser9);
    }
}
