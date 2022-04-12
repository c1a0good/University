package com.project.curriculum.controller;

import com.project.curriculum.domain.Discipline;
import com.project.curriculum.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@CrossOrigin
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @GetMapping
    public List<Discipline> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    @GetMapping("/{id}")
    public Discipline getDisciplineById(@PathVariable Long id) {
        return disciplineService.getDisciplineById(id);
    }

    @PostMapping("/create")
    public Discipline addNewDiscipline(Discipline discipline) {
        return disciplineService.createDiscipline(discipline);
    }

    @PostMapping("/{id}")
    public void updateDiscipline(Discipline discipline) {
        disciplineService.updateDiscipline(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplineById(@PathVariable Long id) {
        disciplineService.deleteDisciplineById(id);
    }

    @DeleteMapping
    public void deleteDisciplinesByIds(List<Long> ids) {
        disciplineService.deleteDisciplinesByIds(ids);
    }

}
