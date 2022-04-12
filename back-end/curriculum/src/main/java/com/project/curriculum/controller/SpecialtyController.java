package com.project.curriculum.controller;

import com.project.curriculum.domain.Specialty;
import com.project.curriculum.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
@CrossOrigin
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/{id}")
    public Specialty getSpecialtyById(@PathVariable Long id) {
        return specialtyService.getSpecialtyById(id);
    }

    @PostMapping("/create")
    public Specialty addNewSpecialty(Specialty specialty) {
        return specialtyService.createSpecialty(specialty);
    }

    @PostMapping("/{id}")
    public void updateSpecialty(Specialty specialty) {
        specialtyService.updateSpecialty(specialty);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialtyById(@PathVariable Long id) {
        specialtyService.deleteSpecialtyById(id);
    }

    @DeleteMapping
    public void deleteSpecialtiesByIds(List<Long> ids) {
        specialtyService.deleteSpecialtiesByIds(ids);
    }

}
