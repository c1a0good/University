package com.project.curriculum.service;

import com.project.curriculum.domain.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);
    List<Faculty> getAllFaculties();
    Faculty getFacultyById(Long id);
    void updateFaculty(Faculty faculty);
    void deleteFacultyById(Long id);
    void deleteFacultiesByIds(List<Long> ids);

}
