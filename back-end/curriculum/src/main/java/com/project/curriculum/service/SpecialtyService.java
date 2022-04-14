package com.project.curriculum.service;

import com.project.curriculum.domain.Discipline;
import com.project.curriculum.domain.Specialty;
import com.project.curriculum.domain.SpecialtyDiscipline;

import java.util.List;

public interface SpecialtyService {

    Specialty createSpecialty(Specialty specialty);
    List<Specialty> getAllSpecialties();
    Specialty getSpecialtyById(Long id);
    List<SpecialtyDiscipline> getAllSpecDisBySpec(Specialty specialty);
    List<SpecialtyDiscipline> getAllSpecDisBySpecAndDis(Specialty specialty, Discipline discipline);
    SpecialtyDiscipline getSpecDisById(Long id);
    SpecialtyDiscipline createSpecDis(SpecialtyDiscipline specialtyDiscipline);
    void updateSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline);
    void deleteSpecialtyDisciplineById(Long id);
    void deleteSpecialtyDisciplinesBySpecialty(Specialty specialty);
    void deleteSpecialtyDisciplinesByDiscipline(Discipline discipline);
    void updateSpecialty(Specialty specialty);
    void deleteSpecialtyById(Long id);

}
