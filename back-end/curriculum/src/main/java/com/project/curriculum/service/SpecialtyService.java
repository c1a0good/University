package com.project.curriculum.service;

import com.project.curriculum.domain.Specialty;

import java.util.List;

public interface SpecialtyService {

    Specialty createSpecialty(Specialty specialty);
    List<Specialty> getAllSpecialties();
    Specialty getSpecialtyById(Long id);
    void updateSpecialty(Specialty specialty);
    void deleteSpecialtyById(Long id);
    void deleteSpecialtiesByIds(List<Long> ids);

}
