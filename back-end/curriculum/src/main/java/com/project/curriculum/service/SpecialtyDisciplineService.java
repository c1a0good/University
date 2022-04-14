package com.project.curriculum.service;

import com.project.curriculum.domain.SpecialtyDiscipline;

import java.util.List;

public interface SpecialtyDisciplineService {

    SpecialtyDiscipline createSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline);
    List<SpecialtyDiscipline> getAllSpecialtiesDisciplines();
    SpecialtyDiscipline getSpecialtyDisciplineById(Long id);
    void updateSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline);
    void deleteSpecialtyDiscipline(Long id);
    void deleteSpecialtiesByIds(List<Long> ids);

}
