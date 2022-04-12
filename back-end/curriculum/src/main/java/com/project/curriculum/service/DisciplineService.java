package com.project.curriculum.service;

import com.project.curriculum.domain.Discipline;

import java.util.List;

public interface DisciplineService {

    Discipline createDiscipline(Discipline discipline);
    List<Discipline> getAllDisciplines();
    Discipline getDisciplineById(Long id);
    void updateDiscipline(Discipline discipline);
    void deleteDisciplineById(Long id);
    void deleteDisciplinesByIds(List<Long> ids);

}
