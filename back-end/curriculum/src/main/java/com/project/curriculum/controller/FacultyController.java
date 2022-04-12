package com.project.curriculum.controller;

import com.project.curriculum.domain.Faculty;
import com.project.curriculum.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@CrossOrigin
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping("/create")
    public Faculty addNewFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PostMapping("/{id}")
    public void updateFaculty(Faculty faculty) {
        facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable("id") Long id) {
        facultyService.deleteFacultyById(id);
    }

    @DeleteMapping
    public void deleteFacultiesByIds(List<Long> ids) {
        facultyService.deleteFacultiesByIds(ids);
    }

}
