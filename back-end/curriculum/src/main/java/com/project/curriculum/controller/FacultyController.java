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

    @PostMapping
    public Faculty addNewFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping("/{id}")
    public void updateFaculty(@PathVariable Long id, Faculty faculty) {
        faculty.setId(id);
        facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable("id") Long id) {
        facultyService.deleteFacultyById(id);
    }

}
