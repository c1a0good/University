package com.project.curriculum.controller;

import com.project.curriculum.domain.Faculty;
import com.project.curriculum.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        if (faculty.getId() == id) facultyService.updateFaculty(faculty);
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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
