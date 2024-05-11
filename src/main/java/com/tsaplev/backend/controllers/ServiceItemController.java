package com.tsaplev.backend.controllers;

import com.tsaplev.backend.repositories.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tsaplev.backend.entities.ServiceItem;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/service-items")
public class ServiceItemController {

    @Autowired
    private ServiceItemRepository serviceItemRepository;

    // CREATE operation
    @PostMapping
    public ResponseEntity<ServiceItem> createServiceItem(@RequestBody ServiceItem serviceItem) {
        ServiceItem savedServiceItem = serviceItemRepository.save(serviceItem);
        return new ResponseEntity<>(savedServiceItem, HttpStatus.CREATED);
    }

    // READ operation
    @GetMapping
    public ResponseEntity<List<ServiceItem>> getAllServiceItems(@RequestParam Map<String, String> queryParameters) {
        List<ServiceItem> serviceItems;
        if (!queryParameters.containsKey("depId")) {
            serviceItems = serviceItemRepository.findAll();
        } else {
            Long depId = Long.parseLong(queryParameters.get("depId"));
            serviceItems = serviceItemRepository.findAllByDepartmentId(depId);
        }
        return new ResponseEntity<>(serviceItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceItem> getServiceItemById(@PathVariable Long id) {
        Optional<ServiceItem> serviceItem = serviceItemRepository.findById(id);
        if (serviceItem.isPresent()) {
            return new ResponseEntity<>(serviceItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceItem(@PathVariable Long id) {
        Optional<ServiceItem> serviceItem = serviceItemRepository.findById(id);
        if (serviceItem.isPresent()) {
            serviceItemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

