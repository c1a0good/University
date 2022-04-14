package com.project.curriculum.service.implementation;

import com.project.curriculum.domain.Discipline;
import com.project.curriculum.domain.Specialty;
import com.project.curriculum.domain.SpecialtyDiscipline;
import com.project.curriculum.repository.SpecialtyDisciplineRepository;
import com.project.curriculum.repository.SpecialtyRepository;
import com.project.curriculum.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SpecialtyDisciplineRepository specialtyDisciplineRepository;

    @Override
    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSpecialty(Specialty specialty) {
        specialtyRepository.update(specialty.getFaculty().getId(), specialty.getName(), specialty.getId());
    }

    @Override
    public void deleteSpecialtyById(Long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public List<SpecialtyDiscipline> getAllSpecDisBySpec(Specialty specialty) {
        return specialtyDisciplineRepository.getAllBySpecialty(specialty);
    }

    @Override
    public List<SpecialtyDiscipline> getAllSpecDisBySpecAndDis(Specialty specialty, Discipline discipline) {
        return specialtyDisciplineRepository.getAllBySpecialtyAndDiscipline(specialty, discipline);
    }

    @Override
    public SpecialtyDiscipline getSpecDisById(Long id) {
        return specialtyDisciplineRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline) {
        specialtyDisciplineRepository.update(
                specialtyDiscipline.getSpecialty().getId(),
                specialtyDiscipline.getDiscipline().getId(),
                specialtyDiscipline.getSemester(),
                specialtyDiscipline.getFormOfControl(),
                specialtyDiscipline.getId());
    }

    @Override
    public void deleteSpecialtyDisciplineById(Long id) {
        specialtyDisciplineRepository.deleteById(id);
    }

    @Override
    public SpecialtyDiscipline createSpecDis(SpecialtyDiscipline specialtyDiscipline) {
        return specialtyDisciplineRepository.save(specialtyDiscipline);
    }

    @Override
    public void deleteSpecialtyDisciplinesBySpecialty(Specialty specialty) {
        specialtyDisciplineRepository.deleteAllBySpecialty(specialty);
    }

    @Override
    public void deleteSpecialtyDisciplinesByDiscipline(Discipline discipline) {
        specialtyDisciplineRepository.deleteAllByDiscipline(discipline);
    }
}
