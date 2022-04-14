package com.project.curriculum.controller;

import com.project.curriculum.domain.Discipline;
import com.project.curriculum.domain.SpecialtyDiscipline;
import com.project.curriculum.service.DisciplineService;
import com.project.curriculum.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@CrossOrigin
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @Autowired
    SpecialtyService specialtyService;

    @GetMapping
    public List<Discipline> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    @GetMapping("/{id}")
    public Discipline getDisciplineById(@PathVariable Long id) {
        return disciplineService.getDisciplineById(id);
    }

    @PostMapping
    public Discipline addNewDiscipline(Discipline discipline) {
        return disciplineService.createDiscipline(discipline);
    }

    @PostMapping("/{id}/specialties")
    public SpecialtyDiscipline addNewSpecialtyInDiscipline(@PathVariable Long id, SpecialtyDiscipline specialtyDiscipline) {
        specialtyDiscipline.setDiscipline(disciplineService.getDisciplineById(id));
        return specialtyService.createSpecDis(specialtyDiscipline);
    }

    @PutMapping("/{id}")
    public void updateDiscipline(@PathVariable Long id, Discipline discipline) {
        discipline.setId(id);
        disciplineService.updateDiscipline(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplineById(@PathVariable Long id) {
        disciplineService.deleteDisciplineById(id);
    }

    @DeleteMapping("/{id}/specialties")
    public void deleteAllDisciplinesInSpecialty(@PathVariable Long id) {
        specialtyService.deleteSpecialtyDisciplinesByDiscipline(disciplineService.getDisciplineById(id));
    }

    @DeleteMapping("/{disId}/specialties/{specId}")
    public void deleteSpecialtyInDisciplineById(@PathVariable Long specId) {
        specialtyService.deleteSpecialtyDisciplineById(specId);
    }

}
