package com.project.curriculum.service.implementation;

import com.project.curriculum.domain.Faculty;
import com.project.curriculum.repository.FacultyRepository;
import com.project.curriculum.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        facultyRepository.update(faculty.getName(), faculty.getId());
    }

    @Override
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public void deleteFacultiesByIds(List<Long> ids) {
        facultyRepository.deleteAllById(ids);
    }

}
