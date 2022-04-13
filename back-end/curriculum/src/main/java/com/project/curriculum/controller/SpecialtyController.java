package com.project.curriculum.controller;

import com.project.curriculum.domain.Specialty;
import com.project.curriculum.domain.SpecialtyDiscipline;
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

    @PostMapping
    public Specialty addNewSpecialty(Specialty specialty) {
        return specialtyService.createSpecialty(specialty);
    }

    @PostMapping("/{id}/disciplines")
    public SpecialtyDiscipline addNewDisciplineInSpecialty(@PathVariable Long id, SpecialtyDiscipline specialtyDiscipline) {
        specialtyDiscipline.setSpecialty(specialtyService.getSpecialtyById(id));
        return specialtyService.createSpecDis(specialtyDiscipline);
    }

    @PutMapping("/{id}")
    public void updateSpecialty(@PathVariable Long id, Specialty specialty) {
        specialty.setId(id);
        specialtyService.updateSpecialty(specialty);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialtyById(@PathVariable Long id) {
        specialtyService.deleteSpecialtyById(id);
    }

    @DeleteMapping("/{id}/disciplines")
    public void deleteAllDisciplinesInSpecialty(@PathVariable Long id) {
        specialtyService.deleteSpecialtyDisciplinesBySpecialty(specialtyService.getSpecialtyById(id));
    }

    @DeleteMapping("/{specId}/disciplines/{disId}")
    public void deleteDisciplineInSpecialtyById(@PathVariable Long disId) {
        specialtyService.deleteSpecialtyDisciplineById(disId);
    }

}
